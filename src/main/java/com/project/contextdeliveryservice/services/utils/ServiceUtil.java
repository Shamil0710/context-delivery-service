package com.project.contextdeliveryservice.services.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Класс ответсвенный за подключение к конкретному сервису
 */
@Component
public class ServiceUtil {
    private static final String APPLICATION_NAME = "Simple-GoogelDocAPI";

    public Drive getDriveService() throws GeneralSecurityException, IOException {
        Credential credential = GoogleAuthorizeUtil.authorize();
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }
}
