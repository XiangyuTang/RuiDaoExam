package com.neuedu.ruidaoexam.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class PaypalConfig {

    @Value("AUNXdvIBUXZYuicnX8WDCqfAoQNUWUwfnoM5VKcOAGsr_4ATQlgd7qwA60YVB1hcyClZ_lb6EcrMKFtv")
    private String clientId;
    @Value("ENaI51uxXFCIwBSyv9Lk8nK94OFng2oAsb9uzFEUpmo2dggn1M6V_EBeVgJHJIp-5KNX2Ku8udNZDkiY")
    private String clientSecret;
    @Value("sandbox")
    private String mode;

    private Logger logger = LoggerFactory.getLogger(PaypalConfig.class);

    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> sdkConfig = new HashMap<>();
        sdkConfig.put("mode", mode);
        return sdkConfig;
    }

    @Bean
    public OAuthTokenCredential authTokenCredential() {
        logger.info(this.toString());
        logger.info(clientId);
        logger.info(clientSecret);
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() {
        APIContext apiContext = null;
        try {
            logger.info(authTokenCredential().toString());
            logger.info(authTokenCredential().getAccessToken());
            apiContext = new APIContext(authTokenCredential().getAccessToken());
            logger.info(apiContext.toString());
            apiContext.setConfigurationMap(paypalSdkConfig());

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return apiContext;
    }
}
