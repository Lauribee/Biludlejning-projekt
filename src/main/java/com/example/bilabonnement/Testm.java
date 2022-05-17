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

        System.out.println(br.getCarFromDB("1234567890"));


        System.out.println(kr.getKundeFromDB("2601011234"));
    }
}
