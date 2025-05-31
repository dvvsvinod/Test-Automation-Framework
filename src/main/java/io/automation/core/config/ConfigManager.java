package io.automation.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;


public class ConfigManager {

    private static final Logger LOGGER = LogManager.getLogger(ConfigManager.class);
    private static ConfigManager configData;
    private AppConfig config;

    private ConfigManager() {
        loadConfig();
    }

    public static synchronized ConfigManager getInstance() {
        if (configData == null) configData = new ConfigManager();
        return configData;
    }

    private void loadConfig() throws RuntimeException {
        LoaderOptions loaderOptions = new LoaderOptions();
        Constructor constructor = new Constructor(AppConfig.class, loaderOptions);
        Yaml yaml = new Yaml(constructor);
        InputStream ioStream = getClass().getClassLoader().getResourceAsStream("config.yaml");
        if (ioStream == null) {
            LOGGER.error("config.yaml" + " not found in classpath");
            throw new RuntimeException("config.yaml not found in classpath");
        }
        config = yaml.load(ioStream);
        LOGGER.info("config.yaml loaded into classpath");
    }

    public AppConfig getConfig() {
        return config;
    }
}
