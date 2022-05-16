package com.example.bilabonnement.repository;

import com.example.bilabonnement.models.Kunde;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class KundeRepository{

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

    public void insertKunde(Kunde kunde) {

        try {

            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO kunder (cprnummer, adresse, navn)" + " VALUES (?, ?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, kunde.getCprnummer());
            pps.setString(2, kunde.getAdresse());
            pps.setString(3, kunde.getNavn());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }

    }

    public Kunde getKundeFromDB(String kundeCPR) throws SQLException {
        createConnection();

        String query = " USE biludlejning";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM kunder" + " WHERE cprnummer =" + " '" + kundeCPR + "'";
        Kunde currentKunde = null;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String cprnummer = rs.getString("cprnummer");
                String adresse = rs.getString("adresse");
                String navn = rs.getString("navn");
                currentKunde = new Kunde(cprnummer, adresse, navn);
            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e.getMessage());
        }
        return currentKunde;
    }



}
