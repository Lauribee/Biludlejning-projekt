package com.example.bilabonnement.controllers;

import com.example.bilabonnement.services.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;


@Controller
    public class IndexController {

        @GetMapping("/")
        public String index() {
            return "index";
        }

        @GetMapping("/dataregistrering")
        public String data() {
            return "dataregistrering";
        }

        @GetMapping("/skaderegistrering")
        public String skadereg() {
            return "skaderegistrering";
        }

        @GetMapping("/udviklere")
        public String udviklere() {
            return "udviklere";
        }

        @GetMapping("/opret-lejeaftale")
        public String opretLejeaftale() {
            return "opret-lejeaftale";
        }

        @GetMapping("/statistik")
        public String stats(Model model) throws SQLException {
            InfoService is = new InfoService();

            int udlejedeBiler = is.getUdlejetBiler();
            double prisPaaUdlejedeBiler = is.getSamletPrisPåBiler();

            model.addAttribute("udlejedeBiler", udlejedeBiler);
            model.addAttribute("prisPaaUdlejedeBiler", prisPaaUdlejedeBiler);

            return "statistik";
        }




}
