package org.example;

import java.sql.*;

public class DatabaseDriver {

    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dba = "mydatabase";
    private final String usr = "root";
    private final String pas = "";

    private static DatabaseDriver instance = new DatabaseDriver();
    private DatabaseDriver() {}

    public static DatabaseDriver getInstance() {
        return instance;
    }

    public void getObraty() {
        String statement = "SELECT * FROM obraty;";
        try (
                Connection connection = DriverManager.getConnection(url + dba, usr, pas);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(statement)
        ) {
            System.out.println("Action: getObraty");
            while(rs.next()) {
                System.out.println(rs.getString("nazev"));
                System.out.println(rs.getInt("hodnota"));
            }
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertObraty() {
        String statement = "INSERT INTO obraty (nazev, hodnota) VALUES ('muj obrat', 420);";
        try (
                Connection connection = DriverManager.getConnection(url + dba, usr, pas);
                Statement stmt = connection.createStatement()
        ) {
            stmt.executeUpdate(statement);
            System.out.println("Action: insertObraty");
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateObraty() {
        String statement = "UPDATE obraty SET hodnota = 69;";
        try (
                Connection connection = DriverManager.getConnection(url + dba, usr, pas);
                Statement stmt = connection.createStatement()
        ) {
            stmt.executeUpdate(statement);
            System.out.println("Action: updateObraty");
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteObraty() {
        String statement = "DELETE FROM obraty;";
        try (
                Connection connection = DriverManager.getConnection(url + dba, usr, pas);
                Statement stmt = connection.createStatement()
        ) {
            stmt.executeUpdate(statement);
            System.out.println("Action: deleteObraty");
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
