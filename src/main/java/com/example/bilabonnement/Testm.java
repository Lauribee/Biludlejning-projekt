package com.example.bilabonnement;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.repository.BilRepository;

public class Testm {



    public static void main(String[] args) {
        BilRepository bilRepository = new BilRepository();

       Bil suz = bilRepository.getCarFromDB("20202020");
       suz.toString();

    }
}
