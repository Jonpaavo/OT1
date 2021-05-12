package sample;

public class Palvelut {
    String toimintaalue;
    private double hinta;
    private double alv;
    String palvelu;
    String kuvaus;

    public Palvelut (String toimintaalue, double hinta, double alv, String palvelu, String kuvaus) {

        this.toimintaalue = toimintaalue;
        this.hinta = hinta;
        this.alv = alv;
        this.palvelu = palvelu;
        this.kuvaus = kuvaus;
    }
    public String getToimintaalue () { return toimintaalue; }

    public void setToimintaalue(String toimintaalue) { this.toimintaalue = toimintaalue; }

    public String getPalvelu () { return palvelu; }

    public void setPalvelu(String palvelu) { this.palvelu = palvelu; }

    public String getKuvaus () { return kuvaus; }

    public void setKuvaus(String kuvaus) { this.kuvaus = kuvaus; }

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


}
