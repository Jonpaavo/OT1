package sample;

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
