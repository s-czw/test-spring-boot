package com.test.callback.callback.service;

import com.test.callback.callback.model.LazopAccessToken;
import com.test.callback.callback.repository.LazopAccessTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallbackErrorService {
    private LazopAccessTokenRepository repository;

    @Autowired
    public CallbackErrorService(LazopAccessTokenRepository repository) {
        this.repository = repository;
    }

    public void handleError(String storer, String errorMessage) {
        LazopAccessToken lazopAccessToken = repository.findByStorer(storer);
        if (lazopAccessToken == null) {
            lazopAccessToken = new LazopAccessToken();
            lazopAccessToken.setStorer(storer);
        }
        lazopAccessToken.setError(true);
        lazopAccessToken.setErrorMessage(errorMessage);
        // TODO: send email in case of error
    }
}
