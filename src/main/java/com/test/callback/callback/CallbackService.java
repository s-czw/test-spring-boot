package com.test.callback.callback;

import com.lazada.lazop.api.LazopClient;
import com.lazada.lazop.api.LazopRequest;
import com.lazada.lazop.api.LazopResponse;
import com.lazada.lazop.util.ApiException;
import org.springframework.stereotype.Service;

@Service
public class CallbackService {
    public void createLazopAccessToken(String authCode) {
        LazopClient client = new LazopClient("https://auth.lazada.com/rest", "100718", "4pcRWwaaRyMeyj86Z87Usv5TsnkmS2LO");
        LazopRequest request = new LazopRequest("/auth/token/create");
        request.addApiParameter("code", authCode);
        System.out.println("authCode: " + authCode);
        try {
            LazopResponse response = client.execute(request);
            System.out.println(response.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
