package DomainOliot;

import java.util.Objects;

/**
 * Kuvaa yksittäistä toiminta-alueella sijatsevaa mökkiä, joka voidaan liittää asiakkaan tekemään varaukseen.
 */
public class Mokki extends DomainOlio {
    private String postinro;
    private String mokkinimi;
    private String katuosoite;
    private String kuvaus;
    private int henkilomaara;
    private String varustelu;
    private double hinta;
    private double alv;
    private int toimintaAlueId;

    public Mokki() {
    }

    public Mokki(int mokkiId, int toimintaAlueId, String postinro, String mokkinimi, String katuosoite, String kuvaus,
                 int henkilomaara, String varustelu, double hinta, double alv) {
        super(mokkiId);
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

    public int getToimintaAlueId() {
        return toimintaAlueId;
    }

    public void setToimintaAlueId(int toimintaAlueId) {
        this.toimintaAlueId = toimintaAlueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mokki)) return false;
        Mokki mokki = (Mokki) o;
        return getHenkilomaara() == mokki.getHenkilomaara() &&
                Double.compare(mokki.getHinta(), getHinta()) == 0 &&
                getPostinro().equals(mokki.getPostinro()) &&
                Objects.equals(getMokkiNimi(), mokki.getMokkiNimi()) &&
                Objects.equals(getKatuosoite(), mokki.getKatuosoite()) &&
                Objects.equals(getKuvaus(), mokki.getKuvaus()) &&
                Objects.equals(getAlv(), mokki.getAlv()) &&
                Objects.equals(getVarustelu(), mokki.getVarustelu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostinro(), getMokkiNimi(), getKatuosoite(), getKuvaus(), getHenkilomaara(), getVarustelu(), getHinta());
    }

    public String getPostinro() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro = postinro;
    }

    public String getMokkiNimi() {
        return mokkinimi;
    }

    public void setMokkiNimi(String mokkiNimi) {
        this.mokkinimi = mokkiNimi;
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

    public double getAlv() {return alv;}

    public void setAlv(double alv) {this.alv = alv;}
}
