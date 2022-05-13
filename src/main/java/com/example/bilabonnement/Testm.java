package com.example.bilabonnement;

import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.repository.KundeRepository;

public class Testm {



    public static void main(String[] args) {
        KundeRepository KR = new KundeRepository();

       Kunde klient = new Kunde("75849109812", "Morbærhegnet 12", "Brian");
       KR.insertKlient(klient);

    }
}
