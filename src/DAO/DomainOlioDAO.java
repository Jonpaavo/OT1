
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
    final static ResourceBundle sqlLauseet = ResourceBundle.getBundle("SQLlauseet");

    Connection getYhteys() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mvj?user=root&password=3n2l4v3d");
    }
}
