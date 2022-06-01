package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.SkadePris;
import com.example.bilabonnement.services.FakturaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class FakturaController {

    private final FakturaService fs = new FakturaService();

    @PostMapping("/index")
    public String fakturaOprettelse(WebRequest dataFraForm) {

        int lejeaftaleID = Integer.parseInt(dataFraForm.getParameter("lejeaftaleID"));
        ArrayList<SkadePris> skader = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            String skadeParam = "skade-" + (i + 1);
            String skadeBeskrivelse = dataFraForm.getParameter(skadeParam);
            if(skadeBeskrivelse == ""){
                break;
            } else {
            String prisParam = "pris-" + (i + 1);
            int skadePris = Integer.parseInt(dataFraForm.getParameter(prisParam));

                SkadePris nySkadePris = new SkadePris(skadeBeskrivelse, skadePris);
                skader.add(nySkadePris);
            }
        }
        System.out.println(fs.skabFaktura(lejeaftaleID, skader));
        return "faktura";
    }

}
