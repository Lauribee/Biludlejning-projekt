package com.example.bilabonnement.models;

public class Kunde {

    private final String cprnummer;
    private final String adresse;
    private final String navn;

    public Kunde(String cprnummer, String adresse, String navn) {
        this.cprnummer = cprnummer;
        this.adresse = adresse;
        this.navn = navn;
    }

    public String getCprnummer() {
        return cprnummer;
    }



    @Override
    public String toString() {
        return "Kunde " +
                "navn: " + navn +
                " || Cpr-nummer: " + cprnummer +
                " || Adresse: " + adresse;
    }
}
