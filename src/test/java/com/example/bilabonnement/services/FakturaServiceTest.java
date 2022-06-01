package com.example.bilabonnement.services;

import com.example.bilabonnement.models.SkadePris;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FakturaServiceTest {

    @Test
    void skabFakturaSkalReturnereEtRigtigtBeløb() {

        //arrange
        var f = new FakturaService();
        ArrayList<SkadePris> skader = new ArrayList<>();
        SkadePris pris1 = new SkadePris("beskrivelse 1", 100);
        SkadePris pris2 = new SkadePris("beskrivelse 2", 11);
        skader.add(pris1);
        skader.add(pris2);

        //act
        var faktura = f.skabFaktura(1, skader);
        String fakturatjek = "Lejeaftale nr = " + "1" + "\n" +
        "Samlet pris = " + "111" + "\n" +
                "Individuelle skader og priser = " + "\n" + "[Skade = " + "beskrivelse 1" + '\n' +
                "Pris = " + "100" + "kr.," + " Skade = " + "beskrivelse 2" + '\n' +
                "Pris = " + "11" + "kr.]";

        //assert - hvad vil vi have resultatet skal være.
        assertEquals(fakturatjek, faktura);

    }

    @Test
    void skabFakturaSkalVæreNulKroner() {
        //arrange
        var f = new FakturaService();
        ArrayList<SkadePris> skader = new ArrayList<>();

        //act
        var faktura = f.skabFaktura(1, skader);
        String fakturatjek = "Lejeaftale nr = " + "1" + "\n" +
                "Samlet pris = " + "0" + "\n" +
                "Individuelle skader og priser = " + "\n" + "[]";

        //assert
        assertEquals(fakturatjek, faktura);

    }
}