package DomainOliot;

/**
 * Abstrakti luokka, joka sisältää kaikkien domain-olioiden yhteiset ominaisuudet.
 */
public abstract class DomainOlio {

    private int id;

    public DomainOlio(int id) {
        this.id = id;
    }

    public DomainOlio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
