package com.example.bilabonnement.models;

public class SkadePris {

    private String skadeBeskrivelse;
    private int skadePris;

    public SkadePris(String skadeBeskrivelse, int skadePris) {
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.skadePris = skadePris;
    }

    public String getSkadeBeskrivelse() {
        return skadeBeskrivelse;
    }

    public void setSkadeBeskrivelse(String skadeBeskrivelse) {
        this.skadeBeskrivelse = skadeBeskrivelse;
    }

    public int getSkadePris() {
        return skadePris;
    }

    public void setSkadePris(int skadePris) {
        this.skadePris = skadePris;
    }

    @Override
    public String toString() {
        return "Skade = " + skadeBeskrivelse + '\n' +
                "Pris = " + skadePris + "kr.";
    }
}
