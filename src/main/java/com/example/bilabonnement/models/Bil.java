package com.example.bilabonnement.models;

public class Bil {

    private String stelnummer;
    private String mærke;
    private String model;
    private double stålpris;
    private double regafgift;
    private double CO2udledning;

    public Bil(String stelnummer, String mærke, String model, double stålpris, double regafgift, double co2udledning) {
        this.stelnummer = stelnummer;
        this.mærke = mærke;
        this.model = model;
        this.stålpris = stålpris;
        this.regafgift = regafgift;
        this.CO2udledning = co2udledning;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "stelnummer='" + stelnummer + '\'' +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", stålpris=" + stålpris +
                ", regafgift=" + regafgift +
                ", CO2udledning=" + CO2udledning +
                '}';
    }
}
