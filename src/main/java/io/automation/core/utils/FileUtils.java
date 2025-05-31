package io.automation.core.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class FileUtils {
    private static final Logger LOGGER = LogManager.getLogger(FileUtils.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String,Object> readJson(String filePath) throws IOException {
        try(InputStream ioStream = Files.newInputStream(Paths.get(filePath))) {
           Map<String,Object> jsonData = objectMapper.readValue(ioStream, Map.class);
            LOGGER.info("Successfully read JSON file :: {}",filePath);
            return jsonData;
        } catch (IOException e) {
            LOGGER.error("Error in reading JSON file :: {}",filePath);
            throw new RuntimeException("Error in reading JSON file :: "+filePath,e);
        }
    }

    public static Properties readPropertyFile(String filePath){
        Properties prop = new Properties();
        try(InputStream ioStream = Files.newInputStream(Paths.get(filePath))){
            prop.load(ioStream);
            LOGGER.info("Successfully loaded property file :: {}",filePath);
            return prop;
        } catch (IOException e) {
            LOGGER.error("Error in reading Property file :: {}",filePath);
            throw new RuntimeException("Error in reading Property file :: "+filePath,e);
        }
    }

    public static void createDirectory(String dirPath){
        try {
            Files.createDirectories(Paths.get(dirPath));
            LOGGER.info("Successfully created directories :: {}",dirPath);
        } catch (IOException e) {
            LOGGER.error("Failed to create directories :: {}",dirPath);
            throw new RuntimeException("Failed to create directories :: "+dirPath,e);
        }
    }

    public static void deleteDirectory(String dirPath){
        try {
            Files.deleteIfExists(Paths.get(dirPath));
            LOGGER.info("Successfully deleted directories :: {}",dirPath);
        } catch (IOException e) {
            LOGGER.error("Failed to delete directories :: {}",dirPath);
            throw new RuntimeException("Failed to delete directories :: "+dirPath,e);
        }
    }
}
