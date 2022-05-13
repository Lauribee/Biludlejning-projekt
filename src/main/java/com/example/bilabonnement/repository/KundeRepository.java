package com.example.bilabonnement.repository;

import com.example.bilabonnement.models.Kunde;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class KundeRepository {

    private Connection con;
    private PreparedStatement pps;
    private Properties properties = new Properties();

    public void createConnection() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/config.properties");

            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected to database");

        } catch (IOException | SQLException e) {
            System.out.println("error");

        }
    }

    public void insertKlient(Kunde klient) {

        try {

            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO kunder (cprnummer, adresse, navn)" + " VALUES (?, ?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, klient.getCprnummer());
            pps.setString(2, klient.getAdresse());
            pps.setString(3, klient.getNavn());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }

    }



}
