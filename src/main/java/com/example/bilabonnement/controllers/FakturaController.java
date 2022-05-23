package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FakturaController {

    @PostMapping("/index")
    public String fakturaOprettelse(WebRequest dataFraForm) {

        return "";
    }

}
