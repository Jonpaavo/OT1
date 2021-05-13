package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lasku {
    String toimintaalue;
    String asiakas;
    String tulopaiva;
    String lahtopaiva;
    String sposti;
    Object henkilomaara, mokki, palvelut;
    int lasku_id;

    public Lasku(String toimintaalue, String tulopaiva, String lahtopaiva, Object henkilomaara, String asiakas ,Object palvelut, Object mokki, String sposti) {

        this.toimintaalue = toimintaalue;
        this.tulopaiva = tulopaiva;
        this.lahtopaiva = lahtopaiva;
        this.henkilomaara = henkilomaara;
        this.asiakas = asiakas;
        this.palvelut = palvelut;
        this.mokki = mokki;
        this.sposti = sposti;
    }

    public Lasku() {
    }

    public Lasku luoLaskuTuloksista(ResultSet tulokset) throws SQLException {
        var lasku = new Lasku();
        lasku.setLasku_id(tulokset.getInt("lasku_id"));
        lasku.setToimintaalue(tulokset.getString("toiminta_alue"));
        lasku.setTulopaiva(tulokset.getString("tulopaiva"));
        lasku.setLahtopaiva(tulokset.getString("lahtopaiva"));
        lasku.setHenkilomaara(tulokset.getString("henkilomaara"));
        lasku.setAsiakas(tulokset.getString("asiakas"));
        lasku.setPalvelut(tulokset.getString("palvelut"));
        lasku.setMokki(tulokset.getString("mokki"));
        lasku.setSposti(tulokset.getString("sposti"));

        return lasku;
    }

    public List<Lasku> lasku_listaa() throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String laskuquery = "SELECT * FROM lasku";

        PreparedStatement lause = connectDB.prepareStatement(laskuquery);

        ResultSet tulokset = lause.executeQuery();

        // Jos kysely ei tuottanut tuloksia, palautetaan tyhjää.
        // Samalla siirrytään ResultSet-olion ensimmäiselle riville.
        if (!tulokset.next()) return null;

        List<Lasku> laskut = new ArrayList<>();

        // Ollaan jo ResultSet-olion ensimmäisellä rivillä. Rivin lukeminen täytyy tapahtua ennen seuraavaa
        // tulokset.next()-metodikutsua!
        do {
            Lasku lasku = luoLaskuTuloksista(tulokset);
            laskut.add(lasku);
        } while (tulokset.next());

        tulokset.close();
        lause.close();
        //yhteys.close();

        return laskut;
    }

    public List<Lasku> listaaLaskut() {
        try {
            return lasku_listaa();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void PoistaLasku(Integer id) throws SQLException {

        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query6 = "DELETE FROM mvj.lasku WHERE lasku_id = ?";

        PreparedStatement lause2 = connectDB.prepareStatement(query6);
        lause2.setInt(1, id);

        lause2.executeUpdate();

        lause2.close();

    }

    public static Integer laskeHinta(Integer id) throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connection = yhteys.getYhteys();

        String query7 = "select datediff((select lahtopaiva from lasku where lasku_id = ?), (select tulopaiva from lasku where lasku_id = ?))";
        PreparedStatement lause7 = connection.prepareStatement(query7);
        lause7.setInt(1, id);
        lause7.setInt(2, id);
        ResultSet tulos = lause7.executeQuery();
        if (!tulos.next()) {
            return null;
        } else {
            System.out.println(tulos.getInt(1) * 200);
            int hinta = tulos.getInt(1)*200;
            lause7.execute();

            lause7.close();
            return hinta;
        }
    }


    public int getLasku_id() {
        return lasku_id;
    }

    public void setLasku_id(int lasku_id) {
        this.lasku_id = lasku_id;
    }

    public String getToimintaalue() {
        return toimintaalue;
    }

    public void setToimintaalue(String toimintaalue) {
        this.toimintaalue = toimintaalue;
    }

    public String getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(String asiakas) {
        this.asiakas = asiakas;
    }

    public Object getMokki() {
        return mokki;
    }

    public void setMokki(String mokki) {
        this.mokki = mokki;
    }

    public Object getPalvelut() {
        return palvelut;
    }

    public void setPalvelut(String palvelut) {
        this.palvelut = palvelut;
    }

    public String getTulopaiva() {
        return tulopaiva;
    }

    public void setTulopaiva(String tulopaiva) {
        this.tulopaiva = tulopaiva;
    }

    public String getLahtopaiva() {
        return lahtopaiva;
    }

    public void setLahtopaiva(String lahtopaiva) {
        this.lahtopaiva = lahtopaiva;
    }

    public Object getHenkilomaara() {
        return henkilomaara;
    }

    public void setHenkilomaara(int henkilomaara) {
        this.henkilomaara = henkilomaara;
    }

    public String getSposti() {
        return sposti;
    }

    public void setSposti(String sposti) {
        this.sposti = sposti;
    }

    public void setHenkilomaara(Object henkilomaara) {
        this.henkilomaara = henkilomaara;
    }

    public void setMokki(Object mokki) {
        this.mokki = mokki;
    }

    public void setPalvelut(Object palvelut) {
        this.palvelut = palvelut;
    }



}


