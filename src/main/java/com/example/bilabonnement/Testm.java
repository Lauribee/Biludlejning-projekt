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

       /*Kunde kundeTest = kr.getKundeFromDB("75849109812");
        System.out.println(kundeTest.toString());
        Bil bilTest = br.getCarFromDB("20202020");
        System.out.println(bilTest);
        Lejeaftale lejeaftaleTest = new Lejeaftale(bilTest, kundeTest);
        System.out.println(lejeaftaleTest);
        lr.insertLejeaftale(lejeaftaleTest);*/
        Lejeaftale newLejeaftale = lr.getLejeaftaleFromDB("75849109812");
        System.out.println(newLejeaftale);



    }
}
