package sample;

import java.util.Date;

public class Varaus {
    String toimintaalue;
    String asiakas;
    String tulopaiva;
    String lahtopaiva;
    String sposti;
    Object henkilomaara, mokki, palvelut;

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
