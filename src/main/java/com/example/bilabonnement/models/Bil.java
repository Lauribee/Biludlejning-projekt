package com.example.bilabonnement.models;

public class Bil {

    public enum BilStatus {
        UDLEJET,
        TILBAGELEVERET,
        AFSLUTTET
    }

    private final String stelnummer;
    private String mærke;
    private final String model;
    private double stålpris;
    private final double regafgift;
    private final double CO2udledning;
    private final BilStatus status;

    public Bil(String stelnummer, String mærke, String model, double stålpris, double regafgift, double co2udledning, BilStatus status) {
        this.stelnummer = stelnummer;
        this.mærke = mærke;
        this.model = model;
        this.stålpris = stålpris;
        this.regafgift = regafgift;
        this.CO2udledning = co2udledning;
        this.status = status;
    }

    public String getStelnummer() {
        return stelnummer;
    }


    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }


    public double getStålpris() {
        return stålpris;
    }

    public void setStålpris(double stålpris) {
        this.stålpris = stålpris;
    }

    public double getRegafgift() {
        return regafgift;
    }


    public BilStatus getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Udlejet bil: " + mærke + " " +
                model +
                " || Info: " +
                " || Stelnummer: " + stelnummer +
                " || Stålpris: " + stålpris + ",-" +
                " || Registreringsafgift: " + regafgift +
                " || CO2udledning: " + CO2udledning + "g/km";

    }
}
