
package DAO;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

/**
 * Abstrakti yläluokka kaikille sovelluksen DAO:ille. Sisältää niiden yhteiset ominaisuudet ja metodit.
 */
abstract class DomainOlioDAO {

    //Sisältää tietokantayhteyden muodostamiseen vaadittavat tiedot
    final static ResourceBundle tkResurssit = ResourceBundle.getBundle("TietokantaResurssit");
    final static ResourceBundle sqlLauseet = ResourceBundle.getBundle("SQLauseet");

    Connection getYhteys() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Salainen123!");
    }
}
