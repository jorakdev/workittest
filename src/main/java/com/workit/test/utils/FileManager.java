package com.workit.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.util.StreamUtils.copyToString;

@Component
public class FileManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileManager.class);

    public String readFile(String path) {
        try {
            return copyToString(new ClassPathResource(path).getInputStream(), UTF_8).trim();
        } catch (IOException e) {
            LOGGER.error("Unable to read file : [{}]", path, e);
        }
        return null;
    }
}
