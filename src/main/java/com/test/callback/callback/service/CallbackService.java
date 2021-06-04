package com.test.callback.callback.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lazada.lazop.api.LazopClient;
import com.lazada.lazop.api.LazopRequest;
import com.lazada.lazop.api.LazopResponse;
import com.lazada.lazop.util.ApiException;
import com.test.callback.callback.model.LazopAccessToken;
import com.test.callback.callback.repository.LazopAccessTokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CallbackService {
    final Logger logger = LoggerFactory.getLogger(CallbackService.class);

    private final String ANTA_STORER = "ANTA";

    public ObjectMapper objectMapper;

    public CallbackErrorService errorService;

    public LazopAccessTokenRepository repository;

    public LazopClient client;

    @Autowired
    public CallbackService(ObjectMapper objectMapper, CallbackErrorService errorService, LazopAccessTokenRepository repository) {
        this.objectMapper = objectMapper;
        this.errorService = errorService;
        this.repository = repository;
        this.client = new LazopClient("https://auth.lazada.com/rest", "100718", "4pcRWwaaRyMeyj86Z87Usv5TsnkmS2LO");
    }

    public void createLazopAccessToken(String authCode) {
        LazopRequest request = new LazopRequest("/auth/token/create");
        request.addApiParameter("code", authCode);
        System.out.println("authCode: " + authCode);
        try {
            LazopResponse response = client.execute(request);
            storeLazopAccessToken(ANTA_STORER, response.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
            errorService.handleError(ANTA_STORER, e.getErrorMessage());
        }
    }

    public void refreshLazopAccessToken(LazopAccessToken lazopAccessToken) {
        if (lazopAccessToken != null) {
            LazopRequest request = new LazopRequest("/auth/token/refresh");
            request.addApiParameter("refresh_token", lazopAccessToken.getRefreshToken());
            try {
                LazopResponse response = client.execute(request);
                System.out.println("response code: " + response.getCode());
                System.out.println("response body: " + response.getBody());
                storeLazopAccessToken(lazopAccessToken.getStorer(), response.getBody());
            } catch (ApiException e) {
                e.printStackTrace();
                errorService.handleError(lazopAccessToken.getStorer(), e.getErrorMessage());
            }
        }
    }

    private void storeLazopAccessToken(String storer, String responseBody) {
        try {
            LazopAccessToken lazopAccessToken = objectMapper.readValue(responseBody, LazopAccessToken.class);
            lazopAccessToken.setStorer(storer);
            long expiration = lazopAccessToken.getExpiresIn() < lazopAccessToken.getRefreshExpiresIn() ?
                    lazopAccessToken.getExpiresIn() : lazopAccessToken.getRefreshExpiresIn();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND, (int) (expiration / 60));
            lazopAccessToken.setScheduledRefreshDate(cal.getTime());
            System.out.println(lazopAccessToken);
            repository.save(lazopAccessToken);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            errorService.handleError(storer, e.getMessage());
        }
    }
}
