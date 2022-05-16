package com.example.bilabonnement.repository;


import com.example.bilabonnement.models.Bil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BilRepository{
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

    public Bil getCarFromDB(String stelnummerFraBil) {
       Bil currentBil = null;
        try {
            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();

            query = " SELECT * FROM biludlejning.biler WHERE stelnummer =  " + stelnummerFraBil;


            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String stelnummer = rs.getString("stelnummer");
                    String mærke = rs.getString("mærke");
                    String model = rs.getString("model");
                    double stålpris = rs.getDouble("stålpris");
                    double regafgift = rs.getDouble("regafgift");
                    double CO2udledning = rs.getDouble("CO2udledning");
                    currentBil = new Bil(stelnummer, mærke, model, stålpris, regafgift, CO2udledning);
                }
            } catch (SQLException e) {
                System.err.println("GOT AN EXCEPTION");
                System.err.println(e.getMessage());
            }
        } catch(java.sql.SQLException e) {
            System.err.println(e);
        }
        return currentBil;
    }
}
