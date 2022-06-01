package com.example.bilabonnement.models;

public class LejeaftaleKrav {
    private final String cprnummer;
    private final String stelnummer;

    public LejeaftaleKrav(String cprnummer, String stelnummer) {
        this.cprnummer = cprnummer;
        this.stelnummer = stelnummer;
    }

    public String getCprnummer() {
        return cprnummer;
    }

    public String getStelnummer() {
        return stelnummer;
    }
}
