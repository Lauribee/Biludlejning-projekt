package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Bil;
import org.springframework.stereotype.Controller;

@Controller
public class BilController {

    public Enum runStatusKontrol(Bil bil) {

        return bil.getStatus();
    }
}
