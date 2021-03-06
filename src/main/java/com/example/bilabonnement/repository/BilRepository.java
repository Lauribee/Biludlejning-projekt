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

    public Bil getCarFromDB(String stelnummerFraBil) {
       Bil currentBil = null;
        try {
            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();

            query = " SELECT * FROM biludlejning.biler WHERE stelnummer =  " + " '" + stelnummerFraBil + "'";


            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String stelnummer = rs.getString("stelnummer");
                    String mærke = rs.getString("mærke");
                    String model = rs.getString("model");
                    double stålpris = rs.getDouble("stålpris");
                    double regafgift = rs.getDouble("regafgift");
                    double CO2udledning = rs.getDouble("CO2udledning");
                    Bil.BilStatus status = Bil.BilStatus.valueOf(rs.getString("status"));

                    currentBil = new Bil(stelnummer, mærke, model, stålpris, regafgift, CO2udledning, status);
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


    /*brugt til at oprette og indsætte biler i databasen fra main, så at man kunne have nogle bil eksempler at teste de forskellige
    funktionaliteter med


    public void insertBil(Bil bil) {

        try {

            createConnection();

            String query = " USE biludlejning";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO biler (stelnummer, mærke, model, stålpris, regafgift, CO2udledning, status)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, bil.getStelnummer());
            pps.setString(2, bil.getMærke());
            pps.setString(3, bil.getModel());
            pps.setDouble(4, bil.getStålpris());
            pps.setDouble(5, bil.getRegafgift());
            pps.setDouble(6, bil.getCO2udledning());
            pps.setString(7, bil.getStatus().toString());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }

    }*/

    public void opdaterBil(String stelnummer, Bil.BilStatus status) throws SQLException {
        createConnection();

        String query = " USE biludlejning";
        pps = con.prepareStatement(query);
        pps.execute();


        query = " UPDATE biler" + " SET status = " + "'" + status + "'" + " WHERE stelnummer = " + "'" + stelnummer + "'";

        pps = con.prepareStatement(query);
        pps.execute();
    }
}
