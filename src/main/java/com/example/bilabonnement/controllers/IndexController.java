package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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

        @GetMapping("/statistik")
        public String stats() {
            return "udviklere";
        }

        @GetMapping("/opret-lejeaftale")
        public String opretLejeaftale() {
            return "opret-lejeaftale";
        }

}
