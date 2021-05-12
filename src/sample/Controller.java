package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    // Luodaan tarvittavat elementit ja listat




    // MÖKIN VARAUS
    public ComboBox cboxToimintaalue;
    public ComboBox cboxHenkilomaara;
    public ComboBox cboxPalvelut;
    public ComboBox cboxMokki;
    //public ComboBox cboxToimintaalue2;
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

    //MÖKINVARAUS TABLE
    public TableView <Varaus> tvTableView;
    public TableColumn<Varaus, String> tcToimintaalue;
    public TableColumn<Varaus, String> tcTulopaiva;
    public  TableColumn<Varaus, String> tcLahtopaiva;
    public  TableColumn<Varaus, Integer> tcHenkilomaara;
    public  TableColumn<Varaus, String> tcAsiakas;
    public  TableColumn<Varaus, String> tcPalvelut;
    public  TableColumn<Varaus, String> tcMokki;
    public TableColumn <Varaus, String> tcSposti;
    // MÖKKIENHALLINTA
    //Mökkienhallinta table
    public TableColumn <Mokki, String> CmokkienhallintaNimi;
    public TableColumn <Mokki, String> CmokkienhallintaOsoite;
    public TableColumn <Mokki, String>CmokkienhallintaKuvaus;
    public TableColumn <Mokki, String>CmokkienhallintaHlomaara;
    public TableColumn <Mokki, String>CmokkienhallintaVarustelu;
    public TableColumn <Mokki, String>CmokkienhallintaPostinro;
    public TableColumn <Mokki, Double> CmokkienhallintaHinta;
    public TableColumn <Mokki, Double> CmokkienhallintaAlv;
    public TableColumn <Mokki, Integer>CmokkienhallintaID;

    public TableView tbvMokkienhallintaMokit;

    public TextField txtfMokkienhallintaMokkinimi;
    public TextField txtfMokkienhallintaKatuosoite;
    public TextField txtfMokkienhallintaKuvaus;
    public TextField txtfMokkienhallintaHlomaara;
    public TextField txtfMokkienhallintaVarustelu;
    public TextField txtfMokkienhallintaPostinumero;
    public TextField txtfMokkienhallintaHinta;
    public TextField txtfMokkienhallintaAlv;
    public TextField txtfMokkienhallintaMokkiID;
    public TextField txtfMokkienhallintaTAid;

    // ASIAKASHALLINTA alustus
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
    public TableColumn tbcPuhelinnro;
    public TableColumn tbcAsiakas_id;



    // Näyttää toiminta-alueet Palveluiden Hallinta - välilehdellä
    public void NaytaToimintaalue3() {
        cboxToimintaalue3.setItems(toimintaaluelista);
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
    public void initialize() {
        NaytaToimintaalue();
        //NaytaToimintaalue2();
        NaytaToimintaalue3();
        NaytaHenkilomaara();
        NaytaPalvelut();
        NaytaMokki();
        Varoitus();
        naytaLaskuTiedot();

        //toimii nyt
        Asiakas asiakas = new Asiakas();
        if (asiakas.listaaAsiakkaat() != null) {
            lataaAsiakasTaulu();
        }
    }

    /**
     * MÖKINVARAUSNÄKYMÄ
     */

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

    //lista johon menee kaikki Varaus-oliot
    ObservableList<Varaus> tilausLista = FXCollections.observableArrayList();
    //lista johon menee kaikki laskutustiedot
    ObservableList<Lasku> LaskuLista = FXCollections.observableArrayList();

    // Lisää varauksen tiedot varausnäytön tauluun
    public void Btlisaa(){

        // näyttää virhetekstin jos käyttäjä unohtaa täyttää kaikki pakolliset kentät
        if (cboxToimintaalue.getSelectionModel().getSelectedItem() == null || cboxHenkilomaara.getSelectionModel().getSelectedItem() == null || tfAsiakas.getCharacters().toString() == "" || cboxMokki.getSelectionModel().getSelectedItem() == null || dptulopaiva.getValue() == null || dplahtopaiva.getValue() == null || tfSposti.getCharacters().toString() == "") {
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
            String sposti = tfSposti.getCharacters().toString();

            tcToimintaalue.setCellValueFactory(new PropertyValueFactory<Varaus, String>("toimintaalue"));
            tcTulopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("tulopaiva"));
            tcLahtopaiva.setCellValueFactory(new PropertyValueFactory<Varaus, String>("lahtopaiva"));
            tcHenkilomaara.setCellValueFactory(new PropertyValueFactory<Varaus, Integer>("henkilomaara"));
            tcAsiakas.setCellValueFactory(new PropertyValueFactory<Varaus, String>("asiakas"));
            tcPalvelut.setCellValueFactory(new PropertyValueFactory<Varaus, String>("palvelut"));
            tcMokki.setCellValueFactory(new PropertyValueFactory<Varaus, String>("mokki"));
            tcSposti.setCellValueFactory(new PropertyValueFactory<Varaus, String>("sposti"));

            tcToimintaalue_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("toimintaalue"));
            tcTulopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("tulopaiva"));
            tcLahtopaiva_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("lahtopaiva"));
            tcHlomaara_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, Integer>("henkilomaara"));
            tcAsiakas_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("asiakas"));
            tcPalvelut_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("palvelut"));
            tcMokki_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("mokki"));
            tcSposti_Lasku.setCellValueFactory(new PropertyValueFactory<Lasku, String>("sposti"));



            // Lisätään tilausListan Itemit tableViewiin
            tvTableView.setItems(tilausLista);
            //Lisätään Laskulistan itemit Laskutusnäytön tableviewiin
            tvLasku.setItems(LaskuLista);

            // tehdään muuttujien perusteella Varaus-olio, joka lisätään tilausListaan
            tilausLista.add(new Varaus(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));
            // tehdään muuttujien perusteella Lasku-olio, jotta saadaan varaustiedot myös laskutusnäyttöön
            LaskuLista.add(new Lasku(toimintaalue, tulopaiva, lahtopaiva, hlomaara, asiakas, palvelut, mokki, sposti));
        }
    }

    /**
     * MÖKKIENHALLINTANÄKYMÄ
     */

    /**Lisätään mökille toiminta-alue ID

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
     */
    //Lisätään lista, johon lisätään kaikki mökki-oliot
    ObservableList<Mokki> mokit = FXCollections.observableArrayList();

    // vaaditaan yhteyden muodostamiseen
    public void PaivitaMokki() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String query1 = "UPDATE mokki SET toimintaalue_id=?, postinro=?,mokkinimi=?,katuosoite=?, kuvaus =?,henkilomaara=?, varustelu=?, hinta=?, alv=? WHERE mokki_id = ?";

            PreparedStatement pst1 = connectDB.prepareStatement(query1);
        } catch (Exception e) {
        }
        return;
    }

    // Lisää mökkien tiedot mökkinäytön tauluun
    public void LisaaMokki() {

        //muuttujat teksikenttien sisällöstä

        int mokkiID = Integer.parseInt(txtfMokkienhallintaMokkiID.getText());
        int toimintaAlueId = Integer.parseInt(txtfMokkienhallintaTAid.getText());
        String mokkinimi = txtfMokkienhallintaMokkinimi.getText();
        String katuosoite = txtfMokkienhallintaKatuosoite.getText();
        String kuvaus = txtfMokkienhallintaKuvaus.getText();
        int henkilomaara = Integer.parseInt(txtfMokkienhallintaHlomaara.getText());
        String varustelu = txtfMokkienhallintaVarustelu.getText();
        String postinro = txtfMokkienhallintaPostinumero.getText();
        double hinta = Double.parseDouble(txtfMokkienhallintaHinta.getText());
        double alv = Double.parseDouble(txtfMokkienhallintaAlv.getText());

        //lisätään taulun sarakkeisiin
        CmokkienhallintaNimi.setCellValueFactory(new PropertyValueFactory<Mokki, String>("mokkinimi"));
        CmokkienhallintaOsoite.setCellValueFactory(new PropertyValueFactory<Mokki, String>("katuosoite"));
        CmokkienhallintaKuvaus.setCellValueFactory(new PropertyValueFactory<Mokki, String>("kuvaus"));
        CmokkienhallintaHlomaara.setCellValueFactory(new PropertyValueFactory<Mokki, String>("henkilomaara"));
        CmokkienhallintaVarustelu.setCellValueFactory(new PropertyValueFactory<Mokki, String>("varustelu"));
        CmokkienhallintaPostinro.setCellValueFactory(new PropertyValueFactory<Mokki, String>("postinro"));
        CmokkienhallintaHinta.setCellValueFactory(new PropertyValueFactory<Mokki, Double>("hinta"));
        CmokkienhallintaAlv.setCellValueFactory(new PropertyValueFactory<Mokki, Double>("alv"));
        CmokkienhallintaID.setCellValueFactory(new PropertyValueFactory<Mokki, Integer>("mokkiID"));


        // lisätään mökki olio, joka lisäätän mökkilistalle
        mokit.add(new Mokki(mokkiID, toimintaAlueId, postinro, mokkinimi, katuosoite, kuvaus,
                henkilomaara, varustelu, hinta, alv));

        //lisätään mökkilista taululle

        tbvMokkienhallintaMokit.setItems(mokit);

        //

        //Lisätään tiedot SQL tietokantaan
        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String query1 = "insert into mokki (mokki_id, toimintaalue_id, postinro,mokkinimi,katuosoite, kuvaus ,henkilomaara, varustelu, hinta, alv)values(?,?,?,?,?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqlmokki = connectDB.prepareStatement(query1);

            //Noudetaan tiedot textfieldistä
            sqlmokki.setInt(1,Integer.parseInt(txtfMokkienhallintaMokkiID.getText()));
            sqlmokki.setInt(2,Integer.parseInt(txtfMokkienhallintaTAid.getText()));
            sqlmokki.setString(3,txtfMokkienhallintaPostinumero.getText());
            sqlmokki.setString(4,txtfMokkienhallintaMokkinimi.getText());
            sqlmokki.setString(5,txtfMokkienhallintaKatuosoite.getText());
            sqlmokki.setString(6,txtfMokkienhallintaKuvaus.getText());
            sqlmokki.setInt(7,Integer.parseInt(txtfMokkienhallintaHlomaara.getText()));
            sqlmokki.setString(8,txtfMokkienhallintaVarustelu.getText());
            sqlmokki.setDouble(9,Double.parseDouble(txtfMokkienhallintaHinta.getText()));
            sqlmokki.setDouble(10,Double.parseDouble(txtfMokkienhallintaAlv.getText()));

            //Suoritetaan SQL komennot
            sqlmokki.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaMokki();

        } catch(Exception e) {
            System.err.println("vahinko");
            System.err.println(e.getMessage());

        }
    }


    // ASIAKASHALLINTA SQL
    // Asiakastaulu

    // Tämä lähinnä testin vuoksi -> vaaditaan kuitenkin yhteyden muodostamiseen
    public void PaivitaAsiakas() {

        try {

            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            String query = "UPDATE asiakas SET postinro = ?, etunimi= ?, sukunimi = ?, lahiosoite = ?, email = ?, puhelinnro = ? WHERE asiakas_id = ?";

            PreparedStatement pst = connectDB.prepareStatement(query);
        } catch (Exception e) {
        }
        return;
    }

    //Asiakkaiden lisääminen sql asiakas tauluun
    public void BtTallennaAsiakas() {

        try {

            //Sql yhteyden määrittäminen
            SQLYhteys connectNow = new SQLYhteys();
            Connection connectDB = connectNow.getYhteys();

            //Sql lause asiakkaiden luomiselle
            String query = "insert into asiakas (postinro,etunimi,sukunimi,lahiosoite,email,puhelinnro)values(?,?,?,?,?,?)";

            //Preparedstatement määrittää sql lauseen
            PreparedStatement sqlasiakas = connectDB.prepareStatement(query);

            //Noudetaan tiedot textfieldistä
            sqlasiakas.setString(1,tfPostinro.getText());
            sqlasiakas.setString(2,tfEtunimi.getText());
            sqlasiakas.setString(3,tfSukunimi.getText());
            sqlasiakas.setString(4,tfLahiosoite.getText());
            sqlasiakas.setString(5,tfEmail.getText());
            sqlasiakas.setString(6,tfPuhelinnro.getText());

            //Suoritetaan SQL komennot
            sqlasiakas.executeUpdate();

            //Kutsutaan metodia, jolla päivitetään tiedot automaattisesti
            PaivitaAsiakas();

        } catch(Exception e) {
        }
    }



    public void lataaAsiakasTaulu() {
        //toimii
        tbvAsiakas.getItems().clear();
        Asiakas asiakashallinta = new Asiakas();
        List<Asiakas> asiakaslista = asiakashallinta.listaaAsiakkaat();
        ObservableList<Asiakas> taulunasiakkaat = FXCollections.observableArrayList(asiakaslista);

        tbcAsiakas_id.setCellValueFactory(
                new PropertyValueFactory<Asiakas, Integer>("asiakas_id"));
        tbcEtunimi.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("etunimi"));
        tbcSukunimi.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("sukunimi"));
        tbcPuhelinnro.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("puhelinnro"));
        tbcEmail.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("email"));
        tbcLahiosoite.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("lahiosoite"));
        tbcPostinro.setCellValueFactory(
                new PropertyValueFactory<Asiakas, String>("postinro"));
        tbvAsiakas.setItems(taulunasiakkaat);
    }


    /**
     * Laskunhallintanäkymä
     */

    //LASKUJEN HALLINTA
    public TextArea txtAreaLaskutiedot_Lasku;
    public Button btLahetaLasku;

    //Laskujenhallinta table
    public TextField tfSposti;
    public TableView <Lasku> tvLasku;
    public TableColumn<Lasku, String> tcToimintaalue_Lasku;
    public TableColumn<Lasku, String> tcTulopaiva_Lasku;
    public TableColumn<Lasku, String> tcLahtopaiva_Lasku;
    public TableColumn<Lasku, Integer> tcHlomaara_Lasku;
    public TableColumn<Lasku, String> tcAsiakas_Lasku;
    public TableColumn<Lasku, String> tcPalvelut_Lasku;
    public TableColumn<Lasku, String> tcMokki_Lasku;
    public TableColumn<Lasku, String> tcSposti_Lasku;

    public void naytaLaskuTiedot() {


        tvLasku.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            if (tvLasku.getSelectionModel().getSelectedItem() != null) {
                txtAreaLaskutiedot_Lasku.setText("Toiminta-alue: " + tvLasku.getSelectionModel().getSelectedItem().toimintaalue + "\nTulopäivä: " + tvLasku.getSelectionModel().getSelectedItem().tulopaiva + "\nLähtöpäivä: " + tvLasku.getSelectionModel().getSelectedItem().lahtopaiva + "\nHenkilömäärä: " + tvLasku.getSelectionModel().getSelectedItem().henkilomaara + "\nAsiakkaan nimi: " + tvLasku.getSelectionModel().getSelectedItem().asiakas + "\nPalvelut: " + tvLasku.getSelectionModel().getSelectedItem().palvelut + "\nMökki: " + tvLasku.getSelectionModel().getSelectedItem().mokki + "\nAsiakkaan sähköpostiosoite: " + tvLasku.getSelectionModel().getSelectedItem().sposti);
            } else {
                txtAreaLaskutiedot_Lasku.setText("Toiminta-alue:\nTulopäivä:\nLähtöpäivä:\nHenkilömäärä:\nAsiakkaan nimi:\nPalvelut:\nMökki:\nAsiakkaan sähköpostiosoite:");
            }
        });
    }

    public void lahetaEmail(String recepient) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String msg = ("Hei, Tässä lasku varaamastasi mökistä\nToiminta-alue: "+tvLasku.getSelectionModel().getSelectedItem().toimintaalue+"\nTulopäivä: "+tvLasku.getSelectionModel().getSelectedItem().tulopaiva+"\nLähtöpäivä: "+tvLasku.getSelectionModel().getSelectedItem().lahtopaiva+"\nHenkilömäärä: "+tvLasku.getSelectionModel().getSelectedItem().henkilomaara+"\nAsiakkaan nimi: "+tvLasku.getSelectionModel().getSelectedItem().asiakas+"\nPalvelut: "+tvLasku.getSelectionModel().getSelectedItem().palvelut+"\nMökki: "+tvLasku.getSelectionModel().getSelectedItem().mokki+"\nSähköpostiosoite: "+tvLasku.getSelectionModel().getSelectedItem().sposti
        +"\n\nLasku maksetaan tilille FI20945830579348\nHinta: XXX");

        String myAccountEmail = "mvjarjestelma@gmail.com";
        String password = "Salasana123";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, msg);
        Transport.send(message);
        System.out.println("Email lähetettiin");
    }
    public static Message prepareMessage(Session session, String myAccountEmail, String recepient, String msg) throws NoClassDefFoundError {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Lasku varaamastasi mökistä");
            message.setText(msg);
            return message;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void btLahetaLasku(ActionEvent actionEvent) throws Exception {
        System.out.println("Toiminta-alue: "+tvLasku.getSelectionModel().getSelectedItem().toimintaalue);
        System.out.println("Tulopäivä: "+tvLasku.getSelectionModel().getSelectedItem().tulopaiva);
        System.out.println("Lähtöpäivä: "+tvLasku.getSelectionModel().getSelectedItem().lahtopaiva);
        System.out.println("Henkilömäärä: "+tvLasku.getSelectionModel().getSelectedItem().henkilomaara);
        System.out.println("Asiakas: "+tvLasku.getSelectionModel().getSelectedItem().asiakas);
        System.out.println("Palvelut: "+tvLasku.getSelectionModel().getSelectedItem().palvelut);
        System.out.println("Mökki: "+tvLasku.getSelectionModel().getSelectedItem().mokki);
        System.out.println("Sähköpostiosoite: "+tvLasku.getSelectionModel().getSelectedItem().sposti);
        lahetaEmail(tvLasku.getSelectionModel().getSelectedItem().sposti);

    }

}