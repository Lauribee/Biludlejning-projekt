package com.example.bilabonnement.models;

public class Lejeaftale {
    private Bil bil;
    private Kunde kunde;
    private boolean erTilbageLeveret;
    private boolean erSkadeRegistreret;

    public Lejeaftale(Bil bil, Kunde kunde) {
        this.bil = bil;
        this.kunde = kunde;
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

    @Override
    public String toString() {
        return "Lejeaftale{" +
                "bil=" + bil +
                ", kunde=" + kunde +
                '}';
    }
}
