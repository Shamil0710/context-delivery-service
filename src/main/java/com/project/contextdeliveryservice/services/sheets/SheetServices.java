package com.project.contextdeliveryservice.services.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.project.contextdeliveryservice.services.sheets.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class SheetServices {
    private static final String SPREADSHEET_ID = "15VzLgPx48NniPbtvDZxDeDA8OlOYZtjMU_Qw73M6EXU";
    private ServiceUtil serviceUtil;
    private String range = "testList!A1:A10";

    @Autowired
    public SheetServices(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    public void sheetTest() throws GeneralSecurityException, IOException {
        Sheets sheets = serviceUtil.getSheetsService();
        ValueRange valueRange = sheets.spreadsheets()
                .values()
                .get(SPREADSHEET_ID, range)
                .execute();
        List<List<Object>> values = valueRange.getValues();
        for (List row : values) {
            System.out.println(row.get(0));
        }
    }
}
