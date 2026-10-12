package com.sgbiblioteca.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection conn;

    static {
        try {
            Properties props = new Properties();

            // Cargar archivo db.properties desde resources/config
            InputStream input = DatabaseConnection.class.getClassLoader()
                    .getResourceAsStream("config/db.properties");

            if (input == null) {
                System.out.println("ERROR: No se encontró el archivo db.properties");
            } else {
                props.load(input);
            }

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        return conn;
    }
}
