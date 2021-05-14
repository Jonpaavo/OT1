package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Asiakas {

    private String postinro;
    private String etunimi;
    private String sukunimi;
    private String lahiosoite;
    private String email;
    private String puhelinnro;
    private int asiakas_id;


    public Asiakas() {
    }

    public Asiakas(String etunimi, String sukunimi, String lahiosoite, String postinro, String email, String puhelinnro) {

        this.postinro = postinro;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.lahiosoite = lahiosoite;
        this.email = email;
        this.puhelinnro = puhelinnro;
    }

    public List<Asiakas> listaa() throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query = "SELECT * FROM asiakas";

        PreparedStatement lause = connectDB.prepareStatement(query);

        ResultSet tulokset = lause.executeQuery();

        if (!tulokset.next()) return null;

        List<Asiakas> asiakkaat = new ArrayList<>();

        do {
            Asiakas asiakas = luoAsiakasTuloksista(tulokset);
            asiakkaat.add(asiakas);
        } while (tulokset.next());

        tulokset.close();
        lause.close();


        return asiakkaat;
    }

    public List<Asiakas> ListaaCboxAsiakas() throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();
        String query = "SELECT asiakas_id FROM asiakas";

        PreparedStatement lause = connectDB.prepareStatement(query);

        ResultSet tulokset = lause.executeQuery();

        if (!tulokset.next()) return null;

        List<Asiakas> asiakkaat = new ArrayList<>();

        do {
            Asiakas asiakas = luoComboboxTuloksista(tulokset);
            asiakkaat.add(asiakas);
        } while (tulokset.next());

        tulokset.close();
        lause.close();


        return asiakkaat;
    }

    private Asiakas luoAsiakasTuloksista(ResultSet tulokset) throws SQLException {
        var asiakas = new Asiakas();
        asiakas.setAsiakas_id(tulokset.getInt("asiakas_id"));
        asiakas.setPostinro(tulokset.getString("postinro"));
        asiakas.setEtunimi(tulokset.getString("etunimi"));
        asiakas.setSukunimi(tulokset.getString("sukunimi"));
        asiakas.setLahiosoite(tulokset.getString("lahiosoite"));
        asiakas.setEmail(tulokset.getString("email"));
        asiakas.setPuhelinnro(tulokset.getString("puhelinnro"));

        return asiakas;
    }

    private Asiakas luoComboboxTuloksista(ResultSet tulokset) throws SQLException {
        var asiakas = new Asiakas();
        asiakas.setAsiakas_id(tulokset.getInt("asiakas_id"));


        return asiakas;
    }

    public List<Asiakas> listaaAsiakkaat() {
        try {
            return listaa();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Asiakas> listaaCombobox() {
        try {
            return ListaaCboxAsiakas();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void PoistaAsiakas(Integer id) throws SQLException {

        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query = "DELETE FROM asiakas WHERE asiakas_id = ?";

        PreparedStatement lause = connectDB.prepareStatement(query);
        lause.setInt(1, id);

        lause.executeUpdate();

        lause.close();

    }

    public int getAsiakas_id() {
        return asiakas_id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id = asiakas_id;
    }

    public String getPostinro() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro = postinro;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getLahiosoite() {
        return lahiosoite;
    }

    public void setLahiosoite(String lahiosoite) {
        this.lahiosoite = lahiosoite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuhelinnro() {
        return puhelinnro;
    }

    public void setPuhelinnro(String puhelinnro) {
        this.puhelinnro = puhelinnro;
    }
}
