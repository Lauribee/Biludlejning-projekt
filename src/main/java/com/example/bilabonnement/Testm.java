package com.example.bilabonnement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Testm {

    public static void main(String[] args) {
         try (OutputStream output = new FileOutputStream("src/main/resources/config.properties")){

             Properties prop = new Properties();

             prop.setProperty("db.url", "127.0.0.1:3306");
             prop.setProperty("db.user", "wetried");
             prop.setProperty("db.password", "bananflue");

             prop.store(output, "");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
