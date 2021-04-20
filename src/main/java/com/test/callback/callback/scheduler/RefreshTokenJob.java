package com.test.callback.callback.scheduler;

import com.test.callback.callback.model.LazopAccessToken;
import com.test.callback.callback.repository.LazopAccessTokenRepository;
import com.test.callback.callback.service.CallbackService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class RefreshTokenJob implements Job {
    private LazopAccessTokenRepository repository;

    private CallbackService callbackService;

    @Autowired
    public RefreshTokenJob(LazopAccessTokenRepository repository, CallbackService callbackService) {
        this.repository = repository;
        this.callbackService = callbackService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<LazopAccessToken> lazopAccessTokenList = repository.findAll();
        for (LazopAccessToken lazopAccessToken : lazopAccessTokenList) {
            Calendar toRefreshBy = Calendar.getInstance();
            toRefreshBy.setTime(lazopAccessToken.getScheduledRefreshDate());
            Calendar now = Calendar.getInstance();
            int dateDiff = toRefreshBy.compareTo(now);
            if (dateDiff <= 0) {
                lazopAccessToken.setError(true);
                lazopAccessToken.setErrorMessage("scheduled refresh timestamp is passed, token possibly invalidated.");
            } else if (dateDiff < 7) {
                lazopAccessToken.setError(false);
                callbackService.refreshLazopAccessToken(lazopAccessToken);
            }
        }
    }
}
