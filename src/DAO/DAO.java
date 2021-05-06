package DAO;

import java.sql.SQLException;

/**
 * Rajapinta, joka määrittää kaikkien DAO-objektien perusmetodien toiminnan.
 *
 * @param <T> Olion tyyppi, jota tämän rajapinnan toteuttava DAO käsittelee.
 * @param <K> Käsiteltävien olioiden yksilöivän tunnisteen tyyppi.
 */
public interface DAO<T, K> {

    void luo(T olio) throws SQLException;

    T lue(K id) throws SQLException;

    void paivita(T olio) throws SQLException;

    void poista(K id) throws SQLException;
}
