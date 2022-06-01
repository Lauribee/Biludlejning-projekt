package com.example.bilabonnement.repository;


import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class LejeaftaleRepository{

    private Connection con;
    private PreparedStatement pps;
    private final KundeRepository kr = new KundeRepository();
    private final BilRepository br = new BilRepository();
    private final Properties properties = new Properties();

    public void createConnection() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/config.properties");

            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            con = DriverManager.getConnection(url, user, password);

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


            query = " INSERT INTO lejeaftaler (cprnummer, stelnummer, status)" + " VALUES (?, ?, ?)";
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
        int lejeaftaleID = 0;
        Lejeaftale currentLejeaftale = null;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lejeaftaleID = rs.getInt("lejeaftaleID");
                cprnummer = rs.getString("cprnummer");
                stelnummer = rs.getString("stelnummer");
                status = rs.getBoolean("status");
            }
            Kunde currentKunde = kr.getKundeFromDB(cprnummer);
            Bil currentBil = br.getCarFromDB(stelnummer);
            currentLejeaftale = new Lejeaftale(currentBil, currentKunde, status, lejeaftaleID);


        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e.getMessage());
        }
        return currentLejeaftale;
    }

    public ArrayList<Lejeaftale> hentAlleLejeaftalerFraDB() throws SQLException {

        createConnection();

        String query = " USE biludlejning";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM lejeaftaler" ;
        ArrayList<Lejeaftale> lejeaftaler = new ArrayList<Lejeaftale>();
        String cprnummer = null;
        String stelnummer = null;
        boolean status = false;
        int lejeaftaleID= 0;
        Lejeaftale currentLejeaftale = null;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lejeaftaleID = rs.getInt("lejeaftaleID");
                cprnummer = rs.getString("cprnummer");
                stelnummer = rs.getString("stelnummer");
                status = rs.getBoolean("status");

                Kunde currentKunde = kr.getKundeFromDB(cprnummer);
                Bil currentBil = br.getCarFromDB(stelnummer);
                currentLejeaftale = new Lejeaftale(currentBil, currentKunde, status, lejeaftaleID);
                lejeaftaler.add(currentLejeaftale);

            }



        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e.getMessage());
        }
        return lejeaftaler;
    }

    public String getBilFraLejeaftale(int lejeaftaleID) throws SQLException {
       String stelnummer = null;

        createConnection();

        String query = " USE biludlejning";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM lejeaftaler" + " WHERE lejeaftaleID =" + " '" + lejeaftaleID + "'";

        try (Statement stmt = con.createStatement()) {


                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    lejeaftaleID = rs.getInt("lejeaftaleID");
                    String cprNummer = rs.getString("cprnummer");
                    stelnummer = rs.getString("stelnummer");
                    boolean status = rs.getBoolean("status");


                }
            } catch (SQLException e) {
                System.err.println("GOT AN EXCEPTION");
                System.err.println(e.getMessage());
                System.err.println(e);
        }
        return stelnummer;
    }


}
