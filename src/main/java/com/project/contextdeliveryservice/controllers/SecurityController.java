package com.project.contextdeliveryservice.controllers;

//import com.project.contextdeliveryservice.services.GoogleSheetsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the club, body!";
    }

//    @GetMapping("/test")
//    public void test() {
//        try {
//            googleSheetsService.readSheet();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
