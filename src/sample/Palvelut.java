package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Palvelut {

    private String nimi;

    private double hinta;
    private double alv;
    private String kuvaus;
    private int toimintaalue_id;
    private int palvelu_id;

    public int getPalvelu_id() {
        return palvelu_id;
    }

    public Palvelut() {
    }

    public Palvelut(String nimi, double hinta, double alv, int toimintaalue_id) {
        this.nimi = nimi;

        this.hinta = hinta;
        this.alv = alv;
        this.toimintaalue_id = toimintaalue_id;
    }


    public List<Palvelut> listaa() throws SQLException {
        SQLYhteys connectNow = new SQLYhteys();
        Connection connectDB = connectNow.getYhteys();

        String query = "SELECT * FROM palvelu";

        PreparedStatement lause = connectDB.prepareStatement(query);

        ResultSet tulokset = lause.executeQuery();
        if (!tulokset.next()) return null;

        List<Palvelut> palvelut = new ArrayList<>();
        do {
            Palvelut palvelu = luoPalveluTuloksista(tulokset);
            palvelut.add(palvelu);
        } while (tulokset.next());

        tulokset.close();
        lause.close();

        return palvelut;

    }

    private Palvelut luoPalveluTuloksista(ResultSet tulokset) throws SQLException {
        var palvelu = new Palvelut();
        palvelu.setPalvelu_id(tulokset.getInt("palvelu_id"));
        palvelu.setToimintaalue_id(tulokset.getInt("toimintaalue_id"));
        palvelu.setNimi(tulokset.getString("nimi"));

        palvelu.setKuvaus(tulokset.getString("kuvaus"));
        palvelu.setHinta(tulokset.getDouble("hinta"));
        palvelu.setAlv(tulokset.getDouble("alv"));

        return palvelu;
    }

    public List<Palvelut> listaaPalvelut() {
        try {
            return listaa();
        } catch (SQLException e) {

            e.printStackTrace();

            return null;
        }
    }

    public void poistaPalvelu(Integer id) throws SQLException{
        SQLYhteys connectNow = new SQLYhteys();
        Connection connectDB = connectNow.getYhteys();

        String query = "DELETE FROM palvelu WHERE palvelu_id =?";

        PreparedStatement lause = connectDB.prepareStatement(query);
        lause.setInt(1, id);

        lause.executeUpdate();
        lause.close();

    }


    public void setPalvelu_id(int palvelu_id) {
        this.palvelu_id = palvelu_id;
    }



    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }




    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public double getAlv() {
        return alv;
    }

    public void setAlv(double alv) {
        this.alv = alv;
    }

    public int getToimintaalue_id() {
        return toimintaalue_id;
    }

    public void setToimintaalue_id(int toimintaalue_id) {
        this.toimintaalue_id = toimintaalue_id;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }


}


