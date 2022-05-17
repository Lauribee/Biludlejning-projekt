package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.models.LejeaftaleKrav;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.repository.KundeRepository;
import com.example.bilabonnement.repository.LejeaftaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class LejeaftaleController {

    LejeaftaleRepository lr = new LejeaftaleRepository();
    KundeRepository kr = new KundeRepository();
    BilRepository br = new BilRepository();

    @PostMapping("/opret-lejeaftale")
    public String opretLejeaftale(LejeaftaleKrav lejeaftalekrav) throws SQLException {
        String cprnummer = lejeaftalekrav.getCprnummer();
        String stelnummer = lejeaftalekrav.getStelnummer();

        System.out.println(stelnummer);
        System.out.println(cprnummer);
        Kunde kunde = kr.getKundeFromDB(cprnummer);
        Bil bil = br.getCarFromDB(stelnummer);


        Lejeaftale lejeaftale = new Lejeaftale(bil, kunde, true);
        System.out.println(lejeaftale.toString());
        lr.indsætLejeaftale(lejeaftale);
        return "redirect:/opret-lejeaftale";
    }


    /*@GetMapping("/lejeaftaler")
    public String wishlist(Model model, LejeaftaleKrav lejeaftaleKrav) throws SQLException {

        String cprnummer = lejeaftaleKrav.getCprnummer();

        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<Lejeaftale>((Collection<? extends Lejeaftale>) lr.getLejeaftaleFromDB(cprnummer));
        System.out.println(lejeaftaler.size());


        model.addAttribute("lejeaftaler", lejeaftaler);

        return "lejeaftaler";

    }*/

}