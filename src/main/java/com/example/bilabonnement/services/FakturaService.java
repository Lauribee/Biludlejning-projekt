package com.example.bilabonnement.services;

import com.example.bilabonnement.models.SkadePris;

import java.util.ArrayList;

public class FakturaService {

    public String skabFaktura(int lejeaftaleID, ArrayList<SkadePris> skader) {
        int samletPris = 0;

        for (int i = 0; i < skader.size(); i++) {

            samletPris = samletPris + skader.get(i).getSkadePris();

        }


        return "Lejeaftale nr = " + lejeaftaleID + "\n" +
                "Samlet pris = " + samletPris + "\n" +
                "Individuelle skader og priser = " + "\n" + skader;

    }
}
