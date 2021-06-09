package com.project.contextdeliveryservice.services;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SheetService {

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    //    private static final String SERVICE_ACCOUNT_EMAIL = "547581693992-compute@developer.gserviceaccount.com";
    private static final String APPLICATION_NAME = "Simple-GoogelDocAPI";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);

    @Bean
    public List getData() throws GeneralSecurityException, IOException {
        List row = new ArrayList();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

//        final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

        Sheets sheets = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) {
            }
        }).setApplicationName(APPLICATION_NAME).build();

        row = sheets.spreadsheets().get("1gKK9dqwX1jLB3xSrNNwmeh-fdNeA1yAD").getRanges();

        return row;
    }

}
