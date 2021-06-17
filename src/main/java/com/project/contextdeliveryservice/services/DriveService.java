package com.project.contextdeliveryservice.services;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.project.contextdeliveryservice.services.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Сервис для работы с гугл диском
 */
@Slf4j
@Service
public class DriveService {

    private final ServiceUtil serviceUtil;

    @Autowired
    public DriveService(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    //Получение файла по id
    public void getFile() throws GeneralSecurityException, IOException {
        log.info("Получение файла из Гугл диска");
        Drive drive = serviceUtil.getDriveService();
        File File = drive.files().get("${file.template}").execute();
    }
}
