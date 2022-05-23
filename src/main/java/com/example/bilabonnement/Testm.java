package com.example.bilabonnement;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.repository.KundeRepository;
import com.example.bilabonnement.repository.LejeaftaleRepository;

import java.sql.SQLException;

public class Testm {



    public static void main(String[] args) throws SQLException {
        KundeRepository kr = new KundeRepository();
        LejeaftaleRepository lr = new LejeaftaleRepository();
        BilRepository br = new BilRepository();

        System.out.println(lr.getLejeaftaleFromDB("75849109812"));


        System.out.println(kr.getKundeFromDB("2601011234"));

        Bil bil = new Bil("1112223334", "Dacia", "Duster", 170, 700, 120, Bil.BilStatus.UDLEJET);
        Kunde kunde = new Kunde("69420", "McDonaldsvej", "Christian Legenden");
        System.out.println(kunde.toString());
        kr.insertKunde(kunde);
        br.insertBil(bil);



    }
}
