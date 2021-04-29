package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import java.util.*;

public class Controller {

    // Luodaan tarvittavat elementit ja listat
    public ComboBox cboxToimintaalue;
    public ComboBox cboxHenkilomaara;
    public ObservableList<String>toimintaaluelista = FXCollections.observableArrayList("Tahko", "Ruka", "Ylläs", "Himos", "Levi", "Koli", "Vuokatti", "Pallas");
    public ObservableList<String>henkilomaaralista = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","yli 10");

    public void initialize() {
        NaytaToimintaalue();
        NaytaHenkilomaara();

    }
    // Lisätään toiminta-alueet comboboxiin
    public void NaytaToimintaalue() {
        cboxToimintaalue.setItems(toimintaaluelista);
    }

    // Lisätään henkilömäärät comboboxiin
    public void NaytaHenkilomaara(){
        cboxHenkilomaara.setItems(henkilomaaralista);
    }

    public void btlisaa(){
        System.out.println(cboxToimintaalue.getSelectionModel().getSelectedItem());
        System.out.println(cboxHenkilomaara.getSelectionModel().getSelectedItem());

    }


}
