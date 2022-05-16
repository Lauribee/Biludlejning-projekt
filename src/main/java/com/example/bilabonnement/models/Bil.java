package com.example.bilabonnement.models;

public class Bil {

    enum Status {
        UDLEJET,
        TILBAGELEVERET,
        AFSLUTTET
    }

    private String stelnummer;
    private String mærke;
    private String model;
    private double stålpris;
    private double regafgift;
    private double CO2udledning;
    private Status status;

    public Bil(String stelnummer, String mærke, String model, double stålpris, double regafgift, double co2udledning, Status status) {
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

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void setRegafgift(double regafgift) {
        this.regafgift = regafgift;
    }

    public double getCO2udledning() {
        return CO2udledning;
    }

    public void setCO2udledning(double CO2udledning) {
        this.CO2udledning = CO2udledning;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bil { " +
                "stelnummer = " + stelnummer;
    }
}
