package Logiikka;
import DAO.MokkiDAO;
import DomainOliot.Mokki;
import DomainOliot.ToimintaAlue;

import java.sql.SQLException;
import java.util.List;



/**
 * Tarjoaa käyttöliittymälle kaikki sen tarvitsemat Mökki-olioihin liittyvät toiminnot.
 * Tarkastaa, että samaa mökkiä ei lisätä kahdesti tietokantaan.
 */
public class Mokkienhallinta {

    private MokkiDAO mokkiDAO;

    public Mokkienhallinta() {
        this.mokkiDAO = new MokkiDAO();
    }

    /**
     * Palauttaa kaikki tallennetut Mökki-oliot toiminta-alue id:tä vastaavalta toiminta-alueelta.
     * Jos mitään ei löydy, palautetaan null.
     *
     * @return Lista tallennetuista Mökki-olioista tai null. SQL-virheen sattuessa palautetaan null.
     */
    public List<Mokki> listaaMokit(int toimintaAlueId) {
        try {
            return mokkiDAO.listaaMokit(toimintaAlueId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Palauttaa annettua nimeä vastaavan Mökki-olion. Jos mitään ei löydy, palautetaan null.
     *
     * @param nimi Haettavan mökin nimi.
     * @return Haettava mökki olio tai null. SQL-virheen sattuessa palautetaan null.
     */
    public Mokki getMokki(String nimi) {
        if (nimi.isEmpty()) return null;

        try {
            return mokkiDAO.lueNimella(nimi);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Palauttaa annettua id:tä vastaavan Mökki-olion. Jos mitään ei löydy, palautetaan null.
     *
     * @param mokkiId Haettavan mökin id.
     * @return Haettava mökki olio tai null. SQL-virheen sattuessa palautetaan null.
     */
    public Mokki getMokki(int mokkiId) {
        try {
            return mokkiDAO.lue(mokkiId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lisää ohjelmaan uuden mökin ja tallentaa sen.
     * Ennen lisäämistä tarkastetaan, että sama mökki ei ole jo tietokannassa.
     * @param mokki Tallennettava Mökki-olio.
     */
    public void lisaaMokki(Mokki mokki) {
        try {
            if (mokki != null && tarkastaEiOleJo(mokki)) mokkiDAO.luo(mokki);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Poistaa annettua id:tä vastaavan rivin tietokannan taulusta "mokki".
     *
     * @param mokkiId Poistettavan mökin id.
     */
    public void poistaMokki(int mokkiId) {
        try {
            mokkiDAO.poista(mokkiId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muuttaa annetun Mokki-olion id:tä vastaavan rivin tietokannan taulusta "mokki" annetun Mokki-olion mukaiseksi.
     *
     * @param mokki Mokki-olio, joka on jo päivitetty vastaamaan haluttua riviä tietokannassa.
     */
    public void paivitaMokki(Mokki mokki) {
        try {
            if (mokki != null) mokkiDAO.paivita(mokki);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean tarkastaEiOleJo(Mokki tarkastettava) {
        try {
            List<Mokki> mokit = mokkiDAO.listaaMokit(ToimintaAlue.Id.KAIKKI);

            if (mokit == null) return true;
            // Jos mökkien katuosoitteet ovat samat, mökit ovat samat.
            for (Mokki mokki : mokit) if (mokki.getKatuosoite().equals(tarkastettava.getKatuosoite())) return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}

