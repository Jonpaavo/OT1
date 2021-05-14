package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mokki {
    private String postinro;
    private String mokkinimi;
    private String katuosoite;
    private String kuvaus;
    private int henkilomaara;
    private String varustelu;
    private double hinta;
    private double alv;
    private int toimintaAlueId;
    private int mokkiID;

    public Mokki(int mokkiID, int toimintaAlueId, String postinro, String mokkinimi, String katuosoite, String kuvaus,
                 int henkilomaara, String varustelu, double hinta, double alv) {
        this.mokkiID = mokkiID;
        this.postinro = postinro;
        this.mokkinimi = mokkinimi;
        this.katuosoite = katuosoite;
        this.kuvaus = kuvaus;
        this.henkilomaara = henkilomaara;
        this.varustelu = varustelu;
        this.hinta = hinta;
        this.toimintaAlueId = toimintaAlueId;
        this.alv= alv;
    }

    public Mokki() {

    }

    public List<Mokki> listaaM() throws SQLException {
        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query1 = "SELECT * FROM mvj.mokki";

        PreparedStatement lause1 = connectDB.prepareStatement(query1);

        ResultSet tulokset1 = lause1.executeQuery();


        if (!tulokset1.next()) return null;

        List<Mokki> mokitlista = new ArrayList<>();

        do {
            Mokki mokki1 = luoMokkiTuloksista(tulokset1);
            mokitlista.add(mokki1);
        } while (tulokset1.next());

        tulokset1.close();
        lause1.close();


        return mokitlista;
    }



    private Mokki luoMokkiTuloksista(ResultSet tulokset1) throws SQLException {
        var mokki1 = new Mokki();
        mokki1.setMokkiID(tulokset1.getInt("mokki_id"));
        mokki1.setPostinro(tulokset1.getString("postinro"));
        mokki1.setMokkinimi(tulokset1.getString("mokkinimi"));
        mokki1.setKatuosoite(tulokset1.getString("katuosoite"));
        mokki1.setKuvaus(tulokset1.getString("kuvaus"));
        mokki1.setHenkilomaara(tulokset1.getInt("henkilomaara"));
        mokki1.setVarustelu(tulokset1.getString("varustelu"));
        mokki1.setHinta(tulokset1.getDouble("hinta"));
        mokki1.setAlv(tulokset1.getDouble("alv"));
        mokki1.setToimintaAlueId(tulokset1.getInt("toimintaalue_id"));


        return mokki1;
    }


    public List<Mokki> listaaMokit() {
        try {
            return listaaM();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void PoistaMokki(Integer id) throws SQLException {

        SQLYhteys yhteys = new SQLYhteys();
        Connection connectDB = yhteys.getYhteys();

        String query4 = "DELETE FROM mvj.mokki WHERE mokki_id = ?";

        PreparedStatement lause1 = connectDB.prepareStatement(query4);
        lause1.setInt(1, id);

        lause1.executeUpdate();

        lause1.close();

        }

    public String getPostinro() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro = postinro;
    }

    public String getMokkinimi() {
        return mokkinimi;
    }

    public void setMokkinimi(String mokkinimi) {
        this.mokkinimi = mokkinimi;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getHenkilomaara() {
        return henkilomaara;
    }

    public void setHenkilomaara(int henkilomaara) {
        this.henkilomaara = henkilomaara;
    }

    public String getVarustelu() {
        return varustelu;
    }

    public void setVarustelu(String varustelu) {
        this.varustelu = varustelu;
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

    public int getToimintaAlueId() {
        return toimintaAlueId;
    }

    public void setToimintaAlueId(int toimintaAlueId) {
        this.toimintaAlueId = toimintaAlueId;
    }

    public int getMokkiID() {
        return mokkiID;
    }

    public void setMokkiID(int mokkiID) {
        this.mokkiID = mokkiID;
    }
}
