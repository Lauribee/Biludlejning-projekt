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

    }
