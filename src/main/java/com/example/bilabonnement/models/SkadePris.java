package com.example.bilabonnement.models;

public class SkadePris {

    private String skadeBeskrivelse;
    private int skadePris;

    public SkadePris(String skadeBeskrivelse, int skadePris) {
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.skadePris = skadePris;
    }


    public int getSkadePris() {
        return skadePris;
    }


    @Override
    public String toString() {
        return "Skade = " + skadeBeskrivelse + '\n' +
                "Pris = " + skadePris + "kr.";
    }
}
