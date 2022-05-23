package com.example.bilabonnement.models;

public class Kunde {

    private String cprnummer;
    private String adresse;
    private String navn;

    public Kunde(String cprnummer, String adresse, String navn) {
        this.cprnummer = cprnummer;
        this.adresse = adresse;
        this.navn = navn;
    }

    public String getCprnummer() {
        return cprnummer;
    }

    public void setCprnummer(String cprnummer) {
        this.cprnummer = cprnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Kunde " +
                "navn: " + navn +
                " || Cpr-nummer: " + cprnummer +
                " || Adresse: " + adresse;
    }
}
