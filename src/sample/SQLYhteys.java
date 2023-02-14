package sample;


import java.sql.Connection;
import java.sql.DriverManager;

public class SQLYhteys {

    public Connection yhteys;
    // Muodostaa SQL-yhteyden
    public Connection getYhteys() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            yhteys = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvj?user=root&password=");

            if (yhteys != null) {
                System.out.println("Yhteys muodostettu!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return yhteys;
    }
}

