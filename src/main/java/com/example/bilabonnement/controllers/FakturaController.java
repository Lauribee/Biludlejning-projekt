package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FakturaController {

    @PostMapping("/skaderegistrering")
    public String registrerSkader() {

        return "";
    }

}
