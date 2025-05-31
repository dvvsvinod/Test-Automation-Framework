package io.automation.core.config;

import lombok.Data;

@Data
public class AppConfig {
    private AppConfigData appConfigData;
    private UiConfigData uiConfigData;
    private ApiConfig apiConfig;

    @Data
    public static class ApiConfig{
        private String baseURI;
    }


    @Data
    public static class AppConfigData {
        private String baseURI;
    }

    @Data
    public static class UiConfigData {
        private String browserType;
        private int pageLoadTimeOut;
        private int explicitWaitTimeOut;
    }


}
