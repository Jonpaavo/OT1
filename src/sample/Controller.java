package sample;


import DAO.MokkiDAO;
import DomainOliot.DomainOlio;
import DomainOliot.Mokki;
import Logiikka.Mokkienhallinta;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.List;

public class Controller {

    // Luodaan tarvittavat elementit ja listat

    // MÖKIN VARAUS
    public ComboBox cboxToimintaalue;
    public ComboBox cboxHenkilomaara;
    public ComboBox cboxPalvelut;
    public ComboBox cboxMokki;
    public ComboBox cboxToimintaalue2;
    public ComboBox cboxToimintaalue3;
    public TextField tfAsiakas;
    public DatePicker dptulopaiva;
    public DatePicker dplahtopaiva;
    public ObservableList<String>toimintaaluelista = FXCollections.observableArrayList("Tahko", "Ruka", "Ylläs", "Himos", "Levi", "Koli", "Vuokatti", "Pallas");
    public ObservableList<String>henkilomaaralista = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","yli 10");
    public ObservableList<String>palvelulista = FXCollections.observableArrayList("Porosafari","Koiravaljakkoajelu","Hevosajelu", "Vesiskootteriajelu","Seikkailupalvelu","Airsoft");
    public ObservableList<String>tahkomokitlista = FXCollections.observableArrayList("Tahko 1", "Tahko 2", "Tahko 3", "Tahko 4", "Tahko 5");
    public ObservableList<String>rukamokitlista = FXCollections.observableArrayList("Ruka 1", "Ruka 2", "Ruka 3", "Ruka 4", "Ruka 5");
    public ObservableList<String>yllasmokitlista = FXCollections.observableArrayList("Ylläs 1", "Ylläs 2", "Ylläs 3", "Ylläs 4", "Ylläs 5");
    public ObservableList<String>himosmokitlista = FXCollections.observableArrayList("Himos 1", "Himos 2", "Himos 3", "Himos 4", "Himos 5");
    public ObservableList<String>levimokitlista = FXCollections.observableArrayList("Levi 1", "Levi 2", "Levi 3", "Levi 4", "Levi 5");
    public ObservableList<String>kolimokitlista = FXCollections.observableArrayList("Koli 1", "Koli 2", "Koli 3", "Koli 4", "Koli 5");
    public ObservableList<String>vuokattimokitlista = FXCollections.observableArrayList("Vuokatti 1", "Vuokatti 2", "Vuokatti 3", "Vuokatti 4", "Vuokatti 5");
    public ObservableList<String>pallasmokitlista = FXCollections.observableArrayList("Pallas 1", "Pallas 2", "Pallas 3", "Pallas 4", "Pallas 5");
    public Text txtVarausVaroitus;

    // Antaa valittavaksi mökit siltä toimialueelta, joka näytöllä on valittuna
    public void NaytaMokki() {
        cboxToimintaalue.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object vanhaArvo, Object uusiArvo) {
                if (uusiArvo.toString() == "Tahko") {
                    cboxMokki.setItems(tahkomokitlista);
                } else if (uusiArvo.toString() == "Ruka") {
                    cboxMokki.setItems(rukamokitlista);
                } else if (uusiArvo.toString() == "Ylläs") {
                    cboxMokki.setItems(yllasmokitlista);
                } else if (uusiArvo.toString() == "Himos") {
                    cboxMokki.setItems(himosmokitlista);
                } else if (uusiArvo.toString() == "Levi") {
                    cboxMokki.setItems(levimokitlista);
                } else if (uusiArvo.toString() == "Koli") {
                    cboxMokki.setItems(kolimokitlista);
                } else if (uusiArvo.toString() == "Vuokatti") {
                    cboxMokki.setItems(vuokattimokitlista);
                } else if (uusiArvo.toString() == "Pallas") {
                    cboxMokki.setItems(pallasmokitlista);
                }
            }
        });
    }

    // Laittaa Varausnäytön varoitustekstin näkymättömäksi
    public void Varoitus() {
        txtVarausVaroitus.setVisible(false);
    }

    //MÖKINVARAUS TABLE
    public TableView <Varaus> tvTableView;
    public TableColumn<Varaus, String> tcToimintaalue;
    public TableColumn<Varaus, String> tcTulopaiva;
    public  TableColumn<Varaus, String> tcLahtopaiva;
    public  TableColumn<Varaus, Integer> tcHenkilomaara;
    public  TableColumn<Varaus, String> tcAsiakas;
    public  TableColumn<Varaus, String> tcPalvelut;
    public  TableColumn<Varaus, String> tcMokki;

    //lista johon menee kaikki Varaus-oliot
    ObservableList<Varaus> tilausLista = FXCollections.observableArrayList();

    // Lisää varauksen tiedot varausnäytön tauluun
    public void Btlisaa(){

        // näyttää virhetekstin jos käyttäjä unohtaa täyttää kaikki pakolliset kentät
        if (cboxToimintaalue.getSelectionModel().getSelectedItem() == null || cboxHenkilomaara.getSelectionModel().getSelectedItem() == null || tfAsiakas.getCharacters().toString() == "" || cboxMokki.getSelectionModel().getSelectedItem() == null || dptulopaiva.getValue() == null || dplahtopaiva.getValue() == null ) {
            txtVarausVaroitus.setVisible(true);
        } else {
            txtVarausVaroitus.setVisible(false);
            //tehdään muuttujat näytöllä olevista objekteista
            String toimintaalue = cboxToimintaalue.getSelectionModel().getSelectedItem().toString();
            String tulopaiva = dptulopaiva.getValue().toString();
            String lahtopaiva = dplahtopaiva.getValue().toString();
            Object hlomaara = cboxHenkilomaara.getSelectionModel().getSelectedItem();
            String asiakas = tfAsiakas.getCharacters().toString();
            Object mokki = cboxMokki.getSelectionModel().getSelectedItem();
            Object palvelut = cboxPalvelut.getSelectionModel().getSelectedItem();

            tcToimintaalue.setCellValueFactory(new PropertyValueFactory<Varaus, String>("toimintaalue"));
            tcTulopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("tulopaiva"));
            tcLahtopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("lahtopaiva"));
            tcHenkilomaara.setCellValueFactory(new PropertyValueFactory<Varaus, Integer>("henkilomaara"));
            tcAsiakas.setCellValueFactory(new PropertyValueFactory<Varaus, String>("asiakas"));
            tcPalvelut.setCellValueFactory(new PropertyValueFactory<Varaus, String>("palvelut"));
            tcMokki.setCellValueFactory(new PropertyValueFactory<Varaus, String>("mokki"));

            // Lisätään tilausListan Itemit tableViewiin
            tvTableView.setItems(tilausLista);

            // tehdään muuttujien perusteella Varaus-olio, joka lisätään tilausListaan
            tilausLista.add(new Varaus(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki));
        }
    }

    // MÖKKIENHALLINTA
    public TableColumn CmokkienhallintaNimi;
    public TableColumn CmokkienhallintaOsoite;
    public TableColumn CmokkienhallintaKuvaus;
    public TableColumn CmokkienhallintaHlomaara;
    public TableColumn CmokkienhallintaVarustelu;
    public TableColumn CmokkienhallintaPostinro;
    public TableColumn CmokkienhallintaHinta;
    public TableColumn CmokkienhallintaAlv;
    public TableColumn CmokkienhallintaID;
    public TableView tbvMokkienhallintaMokit;
    public TextField txtfMokkienhallintaMokkinimi;
    public TextField txtfMokkienhallintaKatuosoite;
    public TextField txtfMokkienhallintaKuvaus;
    public TextField txtfMokkienhallintaHlomaara;
    public TextField txtfMokkienhallintaVarustelu;
    public TextField txtfMokkienhallintaPostinumero;
    public TextField txtfMokkienhallintaHinta;
    public TextField txtfMokkienhallintaAlv;
    // ASIAKASHALLINTA
    public TextField tfEtunimi;
    public TextField tfSukunimi;
    public TextField tfLahiosoite;
    public TextField tfPostinro;
    public TextField tfEmail;
    public TextField tfPuhelinnro;
    public TableView tbvAsiakas;
    public TableColumn tbcEtunimi;
    public TableColumn tbcSukunimi;
    public TableColumn tbcLahiosoite;
    public TableColumn tbcPostinro;
    public TableColumn tbcEmail;


    public void initialize() {
        NaytaToimintaalue();
        NaytaToimintaalue2();
        NaytaToimintaalue3();
        NaytaHenkilomaara();
        NaytaPalvelut();
        NaytaMokki();
        Varoitus();



    }
    // Näyttää toiminta-alueet Palveluiden Hallinta - välilehdellä
    public void NaytaToimintaalue3() {
        cboxToimintaalue3.setItems(toimintaaluelista);
    }

    // Näyttää toiminta-alueet Mökkien Hallinta - välilehdellä
    public void NaytaToimintaalue2() {
        cboxToimintaalue2.setItems(toimintaaluelista);
    }



    // Lisätään toiminta-alueet comboboxiin
    public void NaytaToimintaalue() {
        cboxToimintaalue.setItems(toimintaaluelista);
    }

    // Lisätään henkilömäärät comboboxiin
    public void NaytaHenkilomaara(){
        cboxHenkilomaara.setItems(henkilomaaralista);
    }

    public void NaytaPalvelut(){
        cboxPalvelut.setItems(palvelulista);
    }




    public void LataaTaulu() {
        tbvMokkienhallintaMokit.getItems().clear();
        List<Mokki> mokit;
        Mokkienhallinta mokkienhallinta = new Mokkienhallinta();
        mokit = mokkienhallinta.listaaMokit(HaeToimintaAlueid());
        ObservableList<Mokki> taulunmokit = FXCollections.observableArrayList(mokit);

        CmokkienhallintaNimi.setCellValueFactory(
                new PropertyValueFactory<Mokki, String>("mokkiNimi"));
        CmokkienhallintaPostinro.setCellValueFactory(
                new PropertyValueFactory<Mokki, String>("postinro"));
        CmokkienhallintaOsoite.setCellValueFactory(
                new PropertyValueFactory<Mokki, String>("katuosoite"));
        CmokkienhallintaKuvaus.setCellValueFactory(
                new PropertyValueFactory<Mokki, String>("kuvaus"));
        CmokkienhallintaHlomaara.setCellValueFactory(
                new PropertyValueFactory<Mokki, Integer>("henkilomaara"));
        CmokkienhallintaVarustelu.setCellValueFactory(
                new PropertyValueFactory<Mokki, String>("varustelu"));
        CmokkienhallintaHinta.setCellValueFactory(
                new PropertyValueFactory<Mokki, Integer>("hinta"));
        CmokkienhallintaAlv.setCellValueFactory(
                new PropertyValueFactory<Mokki, Double>("alv"));
        CmokkienhallintaID.setCellValueFactory(
                new PropertyValueFactory<DomainOlio, Integer>("id"));

        tbvMokkienhallintaMokit.setItems(taulunmokit);

        //Poistaa painikkeet käytöstä, jos taulu näyttää kaikki mökit
        boolean isDisabled = true;
        isDisabled = cboxToimintaalue2.getValue().toString().equals("KAIKKI");
        //LukitsePainikkeet(isDisabled);
    }
    /**
     * Lisätään mökille toiminta-alue
     *
     * @return
     */
    public int HaeToimintaAlueid() {
        int toimintaAlueId;
        String toimintaAlueNimi = cboxToimintaalue2.getValue().toString();

        if (toimintaAlueNimi.equals("TAHKO"))
            toimintaAlueId = 1;
        else if (toimintaAlueNimi.equals("RUKA"))
            toimintaAlueId = 2;
        else if (toimintaAlueNimi.equals("YLLÄS"))
            toimintaAlueId = 3;
        else if (toimintaAlueNimi.equals("HIMOS"))
            toimintaAlueId = 4;
        else if (toimintaAlueNimi.equals("LEVI"))
            toimintaAlueId = 5;
        else if (toimintaAlueNimi.equals("KOLI"))
            toimintaAlueId = 6;
        else if (toimintaAlueNimi.equals("VUOKATTI"))
            toimintaAlueId = 7;
        else if (toimintaAlueNimi.equals("PALLAS"))
            toimintaAlueId = 8;
        else
            toimintaAlueId = 0;

        return toimintaAlueId;
    }

    /**
     * Mökkienhallinta-välilehden Tallenna-painikkeen toiminnallisuus
     *
     * @throws SQLException
     */


    public void LisaaMokki() throws SQLException {
        String nimi = txtfMokkienhallintaMokkinimi.getText();
        String osoite = txtfMokkienhallintaKatuosoite.getText();
        String kuvaus = txtfMokkienhallintaKuvaus.getText();
        int hmaara = Integer.parseInt(txtfMokkienhallintaHlomaara.getText());
        String varustelu = txtfMokkienhallintaVarustelu.getText();
        String postinumero = txtfMokkienhallintaPostinumero.getText();
        double hinta = Double.parseDouble(txtfMokkienhallintaHinta.getText());
        double alv = Double.parseDouble(txtfMokkienhallintaAlv.getText());

        Mokki mokki = new Mokki(0, HaeToimintaAlueid(), postinumero, nimi,
                osoite, kuvaus, hmaara, varustelu, hinta,alv);

        MokkiDAO dao = new MokkiDAO();
        dao.luo(mokki);
        LataaTaulu();

    }



    public void mokkinimi(InputMethodEvent inputMethodEvent) {
    }

    public void osoite(InputMethodEvent inputMethodEvent) {
    }

    public void postinro(InputMethodEvent inputMethodEvent) {
    }

    public void hlomaara(InputMethodEvent inputMethodEvent) {
    }

    public void kuvaus(InputMethodEvent inputMethodEvent) {
    }

    public void hinta(InputMethodEvent inputMethodEvent) {
    }

    public void alv(InputMethodEvent inputMethodEvent) {
    }

    public void varustelu(InputMethodEvent inputMethodEvent) {
    }

    public void tallennaPalvelu(ActionEvent actionEvent) {
    }

    public void tallennaAsiakas(ActionEvent actionEvent) {
    }
}
