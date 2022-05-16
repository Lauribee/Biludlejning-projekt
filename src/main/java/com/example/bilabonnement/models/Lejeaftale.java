package com.example.bilabonnement.models;

public class Lejeaftale {
    private Bil bil;
    private Kunde kunde;
    private String status;

    public Lejeaftale(Bil bil, Kunde kunde, String status) {
        this.bil = bil;
        this.kunde = kunde;
        this.status = status;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Lejeaftale{" +
                "bil=" + bil +
                ", kunde=" + kunde +
                ", status=" + status +
                '}';
    }
}
