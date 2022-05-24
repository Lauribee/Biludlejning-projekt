package com.example.bilabonnement.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Repository {
// Virker ikke som den skal lige nu, giver null pointer exceptions i de andre klasse ved con, i stedet for at skabe en connection.

        private Connection con;
        private PreparedStatement pps;
        private Properties properties = new Properties();

        /*ideen var at vi lavede en metode til at oprette forbindelse,
        og så genbruge den hver gang vi skulle oprette forbindelser i de andre
        metoder, men der var noget der ikke virkede så vi lavede metoden der hvor den blev brugt mest også
         */

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

    }
