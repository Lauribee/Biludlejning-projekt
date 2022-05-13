package com.example.bilabonnement.models;

public class Medarbejder {

    private enum Rolle {
        DATAREGISTRERING,
        SKADEREGISTRERING,
        FORRETNINGSUDVIKLERE
    }

    private Rolle rolle;

    public Medarbejder (Rolle rolle) {
        this.rolle = rolle;
    }


}
