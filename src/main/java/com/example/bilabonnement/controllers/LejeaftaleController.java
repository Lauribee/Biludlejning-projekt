package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.repository.LejeaftaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LejeaftaleController {

    LejeaftaleRepository lr = new LejeaftaleRepository();

    @PostMapping("/lejeaftaler")
    public String opretLejeaftale(@RequestBody Bil bil, @RequestBody Kunde kunde) {

        boolean status = true;

        Lejeaftale lejeaftale = new Lejeaftale(bil, kunde, status);
        System.out.println(lejeaftale.toString());
        lr.indsætLejeaftale(lejeaftale);
        return "redirect:/lejeaftaler";
    }

}
