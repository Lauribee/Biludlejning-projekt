package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.repository.LejeaftaleRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class InfoService {
    private LejeaftaleRepository lr = new LejeaftaleRepository();

    public InfoService() {
    }

    public int getUdlejetBiler() throws SQLException {
       ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>(lr.hentAlleLejeaftalerFraDB());
       int udlejedeBiler = 0;
        for (int i = 0; i < lejeaftaler.size(); i++) {
            udlejedeBiler =+ 1 + i;

        }

        return udlejedeBiler;
    }

    public double getSamletPrisPåBiler() throws SQLException {
        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>(lr.hentAlleLejeaftalerFraDB());
        double samletRegAfgiftPris = 0;
        for (int i = 0; i < lejeaftaler.size(); i++) {
            samletRegAfgiftPris = samletRegAfgiftPris + lejeaftaler.get(i).getRegAfgift();

        }
        return samletRegAfgiftPris;
    }
}
