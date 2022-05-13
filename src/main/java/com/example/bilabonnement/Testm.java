package com.example.bilabonnement;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Klient;
import com.example.bilabonnement.repository.BilRepository;
import com.example.bilabonnement.repository.KlientRepository;

public class Testm {



    public static void main(String[] args) {
        KlientRepository KR = new KlientRepository();

       Klient klient = new Klient("75849109812", "Morbærhegnet 12", "Brian");
       KR.insertKlient(klient);

    }
}
