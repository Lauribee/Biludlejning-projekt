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

    public String getStelnummer() {
        return stelnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public String getModel() {
        return model;
    }

    public double getStålpris() {
        return stålpris;
    }

    public double getRegafgift() {
        return regafgift;
    }

    public double getCO2udledning() {
        return CO2udledning;
    }

    @Override
    public String toString() {
        return "Bil { " +
                "stelnummer = " + stelnummer;
    }
}
