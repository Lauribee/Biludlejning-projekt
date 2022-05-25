package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.models.LejeaftaleKrav;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.repository.KundeRepository;
import com.example.bilabonnement.repository.LejeaftaleRepository;
import com.example.bilabonnement.services.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;


@Controller
public class LejeaftaleController {

    LejeaftaleRepository lr = new LejeaftaleRepository();
    KundeRepository kr = new KundeRepository();
    BilRepository br = new BilRepository();
    InfoService is = new InfoService();

    @PostMapping("/opret-lejeaftale")
    public String opretLejeaftale(LejeaftaleKrav lejeaftalekrav) throws SQLException {
        String cprnummer = lejeaftalekrav.getCprnummer();
        String stelnummer = lejeaftalekrav.getStelnummer();

        Kunde kunde = kr.getKundeFromDB(cprnummer);
        Bil bil = br.getCarFromDB(stelnummer);
        int lejeaftaleID = lr.getLejeaftaleFromDB(cprnummer).getLejeaftaleID();

        Lejeaftale lejeaftale = new Lejeaftale(bil, kunde, true, lejeaftaleID);
        System.out.println(lejeaftale.toString());
        lr.indsætLejeaftale(lejeaftale);
        return "redirect:/opret-lejeaftale";
    }


    @GetMapping("/lejeaftaler")
    public String lejeaftaler(Model model) throws SQLException {

        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<Lejeaftale>(lr.hentAlleLejeaftalerFraDB());
        System.out.println(lejeaftaler.size());


        model.addAttribute("lejeaftaler", lejeaftaler);

        return "lejeaftaler";

    }

    @PostMapping("/lejeaftaler")
    public String ændreStatus(WebRequest wr) throws SQLException {
        int lejeaftaleID = Integer.parseInt(wr.getParameter("lejeaftaleID"));

        String statusInput = wr.getParameter("status");

        if (statusInput.equalsIgnoreCase("UDLEJET")) {
            is.opdaterStatusPåBil(lejeaftaleID, Bil.BilStatus.UDLEJET);
        } else if (statusInput.equalsIgnoreCase("TILBAGELEVERET")) {
            is.opdaterStatusPåBil(lejeaftaleID, Bil.BilStatus.TILBAGELEVERET);
        } else if (statusInput.equalsIgnoreCase("AFSLUTTET")) {
            is.opdaterStatusPåBil(lejeaftaleID, Bil.BilStatus.AFSLUTTET);
        }

        return "redirect:/lejeaftaler";
    }

}