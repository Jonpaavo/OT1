package sample;

import java.util.Date;

public class Varaus {
    String toimintaalue, asiakas, mokki, palvelut, tulopaiva, lahtopaiva;
    int henkilomaara;

    public Varaus(String toimintaalue, String tulopaiva, String lahtopaiva, int henkilomaara, String asiakas ,String palvelut, String mokki) {

        this.toimintaalue = toimintaalue;
        this.tulopaiva = tulopaiva;
        this.lahtopaiva = lahtopaiva;
        this.henkilomaara = henkilomaara;
        this.asiakas = asiakas;
        this.mokki = mokki;
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

    public String getMokki() {
        return mokki;
    }

    public void setMokki(String mokki) {
        this.mokki = mokki;
    }

    public String getPalvelut() {
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

    public int getHenkilomaara() {
        return henkilomaara;
    }

    public void setHenkilomaara(int henkilomaara) {
        this.henkilomaara = henkilomaara;
    }


}
