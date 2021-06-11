package com.project.contextdeliveryservice.comtrollers;

import com.project.contextdeliveryservice.services.sheets.SheetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class TestController {

    private SheetServices services;

    @Autowired
    public TestController(SheetServices services) {
        this.services = services;
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
}
