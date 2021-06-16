package com.project.contextdeliveryservice.comtrollers;

import com.project.contextdeliveryservice.services.sheets.DocService;
import com.project.contextdeliveryservice.services.sheets.SheetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class TestController {

    private final SheetServices services;
    private final DocService docService;

    @Autowired
    public TestController(SheetServices services, DocService docService) {
        this.services = services;
        this.docService = docService;
    }

    @GetMapping("/test")
    public void test() {
        try {
            services.sheetTest();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/doctest")
    public void docTest () throws GeneralSecurityException, IOException {
        docService.docTest();
    }
}
