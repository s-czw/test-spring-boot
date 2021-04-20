package com.test.callback.callback;

import com.test.callback.callback.model.LazopAccessToken;
import com.test.callback.callback.model.LazopCountryUserInfo;
import com.test.callback.callback.repository.LazopAccessTokenRepository;
import com.test.callback.callback.service.CallbackService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

@SpringBootTest
public class CallbackMongoTests {
    static final Logger logger = LoggerFactory.getLogger(CallbackMongoTests.class);

    @Autowired
    LazopAccessTokenRepository repository;

    @Autowired
    CallbackService callbackService;

    @PostConstruct
    public void setup() {
        if (repository.findByStorer("ANTA") == null) {
            LazopAccessToken lazopAccessToken = new LazopAccessToken();
            lazopAccessToken.setStorer("ANTA");
            lazopAccessToken.setCode("0");
            lazopAccessToken.setCountry("my");
            lazopAccessToken.setAccount("seanczw@gmail.com");
            lazopAccessToken.setRequestId("0ba9636316187370571633134");
            lazopAccessToken.setAccountPlatform("seller_center");
            lazopAccessToken.setAccessToken("50000301102y1N1ffbb19ebZ0j2hiSZtOldjavALRxGJDMnzmyVGj48qQtXoS2Gp");
            lazopAccessToken.setRefreshToken("50001301902fwN1a5a0ac5bsqgfgbS3mR2jndPnWDuWnCzFsxiwv2xloXEIo8T5i");
            lazopAccessToken.setExpiresIn(2592000);
            lazopAccessToken.setRefreshExpiresIn(15552000);
            LazopCountryUserInfo lazopCountryUserInfo = new LazopCountryUserInfo();
            lazopCountryUserInfo.setCountry("my");
            lazopCountryUserInfo.setUserId("300151260113");
            lazopCountryUserInfo.setSellerId("300151260113");
            lazopCountryUserInfo.setShortCode("MY4N9THGTY");
            lazopAccessToken.getCountryUserInfo().add(lazopCountryUserInfo);
            repository.save(lazopAccessToken);
        }
    }

    @Test
    public void mongoDBTest() {
        LazopAccessToken lazopAccessToken = repository.findByStorer("ANTA");
        logger.info("===== lazopAccessToken: {}", lazopAccessToken);
    }

    @Test
    public void testScheduler() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
