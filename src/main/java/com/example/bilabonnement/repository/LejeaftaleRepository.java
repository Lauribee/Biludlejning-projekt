package com.example.bilabonnement.repository;


import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class LejeaftaleRepository{

    private Connection con;
    private PreparedStatement pps;
    private KundeRepository kr = new KundeRepository();
    private BilRepository br = new BilRepository();
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

    public void indsætLejeaftale(Lejeaftale lejeaftale) {

        Kunde lejeaftaleKunde = lejeaftale.getKunde();
        Bil lejeaftaleBil = lejeaftale.getBil();

        String cprnummer = lejeaftaleKunde.getCprnummer();
        String stelnummer = lejeaftaleBil.getStelnummer();
        boolean status = lejeaftale.getStatus();

        try {

            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO lejeaftaler (cprnummer, stelnummer)" + " VALUES (?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, cprnummer);
            pps.setString(2, stelnummer);
            pps.setBoolean(3, status);

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }

    }

    public Lejeaftale getLejeaftaleFromDB(String kundeCPR) throws SQLException {
        createConnection();

        String query = " USE biludlejning";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM lejeaftaler" + " WHERE cprnummer =" + " '" + kundeCPR + "'";
        String cprnummer = null;
        String stelnummer = null;
        boolean status = false;
        Lejeaftale currentLejeaftale = null;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int lejeaftaleID = rs.getInt("lejeaftaleID");
                cprnummer = rs.getString("cprnummer");
                stelnummer = rs.getString("stelnummer");
                status = rs.getBoolean("status");
            }
            Kunde currentKunde = kr.getKundeFromDB(cprnummer);
            Bil currentBil = br.getCarFromDB(stelnummer);
            currentLejeaftale = new Lejeaftale(currentBil, currentKunde, status);


        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e.getMessage());
        }
        return currentLejeaftale;
    }

}
