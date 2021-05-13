package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Varaus {
    private String toimintaalue;
    private String asiakas;
    private String tulopaiva;
    private String lahtopaiva;
    private String sposti;
    private Object henkilomaara, mokki, palvelut;
    private int varaus_id;

    public Varaus(String toimintaalue, String tulopaiva, String lahtopaiva, Object henkilomaara, String asiakas ,Object palvelut, Object mokki, String sposti) {

        this.toimintaalue = toimintaalue;
        this.tulopaiva = tulopaiva;
        this.lahtopaiva = lahtopaiva;
        this.henkilomaara = henkilomaara;
        this.asiakas = asiakas;
        this.palvelut = palvelut;
        this.mokki = mokki;
        this.sposti = sposti;
    }

    public Varaus() {

    }

    public Varaus luoVarausTuloksista(ResultSet tulokset) throws SQLException {
        var varaus = new Varaus();
        varaus.setVaraus_id(tulokset.getInt("varaus_id"));
        varaus.setToimintaalue(tulokset.getString("toiminta_alue"));
        varaus.setTulopaiva(tulokset.getString("tulopaiva"));
        varaus.setLahtopaiva(tulokset.getString("lahtopaiva"));
        varaus.setHenkilomaara(tulokset.getString("henkilomaara"));
        varaus.setAsiakas(tulokset.getString("asiakas"));
        varaus.setPalvelut(tulokset.getString("palvelut"));
        varaus.setMokki(tulokset.getString("mokki"));
        varaus.setSposti(tulokset.getString("sposti"));

        return varaus;
    }

    public List<Varaus> varaus_listaa() throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query = "SELECT * FROM varaus";

        PreparedStatement lause = connectDB.prepareStatement(query);

        ResultSet tulokset = lause.executeQuery();

        // Jos kysely ei tuottanut tuloksia, palautetaan tyhjää.
        // Samalla siirrytään ResultSet-olion ensimmäiselle riville.
        if (!tulokset.next()) return null;

        List<Varaus> varaukset = new ArrayList<>();

        // Ollaan jo ResultSet-olion ensimmäisellä rivillä. Rivin lukeminen täytyy tapahtua ennen seuraavaa
        // tulokset.next()-metodikutsua!
        do {
            Varaus varaus = luoVarausTuloksista(tulokset);
            varaukset.add(varaus);
        } while (tulokset.next());

        tulokset.close();
        lause.close();
        //yhteys.close();

        return varaukset;
    }

    public List<Varaus> listaaVaraukset() {
        try {
            return varaus_listaa();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void PoistaVaraus(Integer id) throws SQLException {

        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query4 = "DELETE FROM mvj.varaus WHERE varaus_id = ?";
        String query5 = "DELETE FROM mvj.lasku WHERE lasku_id = ?";

        PreparedStatement lause2 = connectDB.prepareStatement(query4);
        lause2.setInt(1, id);
        lause2.executeUpdate();
        lause2.close();

        PreparedStatement lause3 = connectDB.prepareStatement(query5);
        lause3.setInt(1, id);
        lause3.executeUpdate();
        lause3.close();

    }

    public int getVaraus_id() {
        return varaus_id;
    }

    public void setVaraus_id(int varaus_id) {
        this.varaus_id = varaus_id;
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
