package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

import java.util.*;

public class Controller {

    // Luodaan tarvittavat elementit ja listat
    public ComboBox cboxToimintaalue;
    public ComboBox cboxHenkilomaara;
    public ComboBox cboxPalvelut;
    public ComboBox cboxMokki;
    public ComboBox cboxToimintaalue2;
    public ComboBox cboxToimintaalue3;
    public TextField tfAsiakas;
    public TextField tftoimintaalue;
    public DatePicker dptulopaiva;
    public DatePicker dplahtopaiva;
    public ObservableList<String>toimintaaluelista = FXCollections.observableArrayList("Tahko", "Ruka", "Ylläs", "Himos", "Levi", "Koli", "Vuokatti", "Pallas");
    public ObservableList<String>henkilomaaralista = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","yli 10");
    public ObservableList<String>palvelulista = FXCollections.observableArrayList("Porosafari","Koiravaljakkoajelu","Hevosajelu", "Vesiskootteriajelu","Seikkailupalvelu","Airsoft");
    public ObservableList<String>tahkomokitlista = FXCollections.observableArrayList("Tahko 1", "Tahko 2", "Tahko 3");
    public ObservableList<String>rukamokitlista = FXCollections.observableArrayList("Ruka 1", "Ruka 2", "Ruka 3");
    public ObservableList<String>yllasmokitlista = FXCollections.observableArrayList("Ylläs 1", "Ylläs 2", "Ylläs 3");
    public ObservableList<String>himosmokitlista = FXCollections.observableArrayList("Himos 1", "Himos 2", "Himos 3");
    public ObservableList<String>levimokitlista = FXCollections.observableArrayList("Levi 1", "Levi 2", "Levi 3");
    public ObservableList<String>kolimokitlista = FXCollections.observableArrayList("Koli 1", "Koli 2", "Koli 3");
    public ObservableList<String>vuokattimokitlista = FXCollections.observableArrayList("Vuokatti 1", "Vuokatti 2", "Vuokatti 3");
    public ObservableList<String>pallasmokitlista = FXCollections.observableArrayList("Pallas 1", "Pallas 2", "Pallas 3");


    public void initialize() {
        NaytaToimintaalue();
        NaytaToimintaalue2();
        NaytaToimintaalue3();
        NaytaHenkilomaara();
        NaytaPalvelut();
        NaytaMokki();
    }
    // Näyttää toiminta-alueet Palveluiden Hallinta - välilehdellä
    public void NaytaToimintaalue3() {
        cboxToimintaalue3.setItems(toimintaaluelista);
    }

    // Näyttää toiminta-alueet Mökkien Hallinta - välilehdellä
    public void NaytaToimintaalue2() {
        cboxToimintaalue2.setItems(toimintaaluelista);
    }

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
    // tulostaa näytöllä valitut tiedot väliaikaisesti, nää laitetaan aikanaan menemään tietokantaan
    public void Btlisaa(){
        System.out.println(cboxToimintaalue.getSelectionModel().getSelectedItem());
        System.out.println(cboxHenkilomaara.getSelectionModel().getSelectedItem());
        System.out.println(cboxPalvelut.getSelectionModel().getSelectedItem());
        System.out.println(dptulopaiva.getValue());
        System.out.println(dplahtopaiva.getValue());
        System.out.println(tfAsiakas.getCharacters());
        System.out.println(cboxMokki.getSelectionModel().getSelectedItem());

    }

    public void BtTallenna(){
        System.out.println(tftoimintaalue.getCharacters());
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
}
