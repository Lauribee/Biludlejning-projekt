package com.example.bilabonnement.models;

public class Lejeaftale {
    private Bil bil;
    private Kunde kunde;
    private boolean status;
    private int lejeaftaleID;

    public Lejeaftale(Bil bil, Kunde kunde, boolean status, int lejeaftaleID) {
        this.bil = bil;
        this.kunde = kunde;
        this.status = true;
        this.lejeaftaleID = lejeaftaleID;
    }

    public Bil getBil() {
        return bil;
    }


    public Kunde getKunde() {
        return kunde;
    }


    public boolean getStatus() {
        return status;
    }


    public double getRegAfgift() {
        return this.bil.getRegafgift();
    }

    public int getLejeaftaleID() {
        return lejeaftaleID;
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
