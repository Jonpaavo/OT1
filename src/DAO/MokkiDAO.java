package DAO;

import DomainOliot.Mokki;
import DomainOliot.ToimintaAlue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MokkiDAO extends DomainOlioDAO implements DAO<Mokki, Integer> {

    /**
     * Tallentaa uuden Mokki-olion tietokantaan.
     *
     * @param mokki Tallennettava Mokki-olio.
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    @Override
    public void luo(Mokki mokki) throws SQLException {
        Connection yhteys = getYhteys();

        PreparedStatement lause = luoMokinLuomislause(yhteys, mokki);

        lause.executeUpdate();

        lause.close();
        yhteys.close();
    }

    /**
     * Palauttaa halutun Mokki-olion tietokannasta.
     *
     * @param id Halutun Mokki-olion id.
     * @return Tietokannan palauttama Mokki-olio. Voi olla null!
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    @Override
    public Mokki lue(Integer id) throws SQLException {
        Connection yhteys = getYhteys();

        PreparedStatement lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiLue"));
        lause.setInt(1, id);
        ResultSet tulokset = lause.executeQuery();

        //Jos tuloksissa ei ole yhtäkään riviä, palauta tyhjää.
        if (!tulokset.next()) return null;

        Mokki mokki = luoMokkiTuloksista(tulokset);

        tulokset.close();
        lause.close();
        yhteys.close();

        return mokki;
    }

    /**
     * Palauttaa halutun Mökki-olion tietokannasta.
     *
     * @param nimi Halutun Mökki-olion nimi.
     * @return Tietokannan palauttama Mökki-olio.
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    public Mokki lueNimella(String nimi) throws SQLException {
        Connection yhteys = getYhteys();

        PreparedStatement lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiLueNimella"));
        lause.setString(1, nimi);
        ResultSet tulokset = lause.executeQuery();

        //Jos tuloksissa ei ole yhtäkään riviä, palauta tyhjää.
        if (!tulokset.next()) return null;

        Mokki mokki = luoMokkiTuloksista(tulokset);

        tulokset.close();
        lause.close();
        yhteys.close();

        return mokki;
    }

    /**
     * Päivittää annettua Mokki-oliota vastaavan rivin tietokannassa. Rivi tunnistetaan mokki_id:n perusteella.
     *
     * @param mokki Päivitettävä Mokki-olio.
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    @Override
    public void paivita(Mokki mokki) throws SQLException {
        Connection yhteys = getYhteys();

        PreparedStatement lause = luoMokinPaivityslause(yhteys, mokki);

        lause.executeUpdate();

        lause.close();
        yhteys.close();
    }

    /**
     * Poistaa annettua mokki_id:tä vastaavan rivin tietokannasta.
     *
     * @param id Poistettavan rivin mokki_id.
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    @Override
    public void poista(Integer id) throws SQLException {
        Connection yhteys = getYhteys();

        PreparedStatement lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiPoista"));
        lause.setInt(1, id);

        lause.executeUpdate();

        lause.close();
        yhteys.close();
    }

    /**
     * Palauttaa listan kaikista tietokannassa olevista Mokki-olioista.
     *
     * @return Lista kaikista Mokki-olioista.
     * @throws SQLException Heitetään, jos tietokannan kanssa kommunikoinnissa ilmenee ongelmia.
     */
    public List<Mokki> listaaMokit(int toimintaAlueId) throws SQLException {

        Connection yhteys = getYhteys();
        PreparedStatement lause;

        switch (toimintaAlueId) {
            case ToimintaAlue.Id.KAIKKI:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaa"));
                break;
            case ToimintaAlue.Id.RUKA:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaRuka"));
                break;
            case ToimintaAlue.Id.YLLAS:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaYllas"));
                break;
            case ToimintaAlue.Id.TAHKO:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaTahko"));
                break;
            case ToimintaAlue.Id.LEVI:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaLevi"));
                break;
            case ToimintaAlue.Id.PALLAS:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaPallas"));
                break;
            case ToimintaAlue.Id.KOLI:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaKoli"));
                break;
            case ToimintaAlue.Id.VUOKATTI:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaVuokatti"));
                break;
            case ToimintaAlue.Id.HIMOS:
                lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiListaaHimos"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + toimintaAlueId);
        }

        ResultSet tulokset = lause.executeQuery();

        // Jos kysely ei tuottanut tuloksia, palautetaan tyhjää.
        // Samalla siirrytään ResultSet-olion ensimmäiselle riville.
        if (!tulokset.next()) return null;

        List<Mokki> mokit = new ArrayList<>();

        // Ollaan jo ResultSet-olion ensimmäisellä rivillä. Rivin lukeminen täytyy tapahtua ennen seuraavaa
        // tulokset.next()-metodikutsua!
        do {
            Mokki mokki = luoMokkiTuloksista(tulokset);
            mokit.add(mokki);
        } while (tulokset.next());

        tulokset.close();
        lause.close();
        yhteys.close();

        return mokit;
    }

    private PreparedStatement luoMokinLuomislause(Connection yhteys, Mokki mokki) throws SQLException {
        PreparedStatement lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiLuo"));
        lause.setInt(1, mokki.getToimintaAlueId());
        lause.setString(2, mokki.getPostinro());
        lause.setString(3, mokki.getMokkiNimi());
        lause.setString(4, mokki.getKatuosoite());
        lause.setString(5, mokki.getKuvaus());
        lause.setInt(6, mokki.getHenkilomaara());
        lause.setString(7, mokki.getVarustelu());
        lause.setDouble(8, mokki.getHinta());
        lause.setDouble(9,mokki.getAlv());

        return lause;
    }

    private PreparedStatement luoMokinPaivityslause(Connection yhteys, Mokki mokki) throws SQLException {
        PreparedStatement lause = yhteys.prepareStatement(sqlLauseet.getString("mokkiPaivita"));
        lause.setInt(1, mokki.getToimintaAlueId());
        lause.setString(2, mokki.getPostinro());
        lause.setString(3, mokki.getMokkiNimi());
        lause.setString(4, mokki.getKatuosoite());
        lause.setString(5, mokki.getKuvaus());
        lause.setInt(6, mokki.getHenkilomaara());
        lause.setString(7, mokki.getVarustelu());
        lause.setDouble(8, mokki.getHinta());
        lause.setDouble(9,mokki.getAlv());
        //Id on sql-lauseessa viimeisenä (WHERE rajoitteen jälkeen)
        lause.setInt(9, mokki.getId());

        return lause;
    }

    private Mokki luoMokkiTuloksista(ResultSet tulokset) throws SQLException {
        var mokki = new Mokki();
        mokki.setId(tulokset.getInt("mokki_id"));
        mokki.setToimintaAlueId(tulokset.getInt("toimintaalue_id"));
        mokki.setPostinro(tulokset.getString("postinro"));
        mokki.setMokkiNimi(tulokset.getString("mokkinimi"));
        mokki.setKatuosoite(tulokset.getString("katuosoite"));
        mokki.setKuvaus(tulokset.getString("kuvaus"));
        mokki.setHenkilomaara(tulokset.getInt("henkilomaara"));
        mokki.setVarustelu(tulokset.getString("varustelu"));
        mokki.setHinta(tulokset.getDouble("hinta"));
        mokki.setAlv(tulokset.getDouble("alv"));

        return mokki;
    }
}
