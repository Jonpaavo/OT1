package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;


public class Controller {
    public void button(ActionEvent actionEvent) throws Exception {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tokanaytto.fxml")));
        Scene kehys = new Scene(root1);
        Stage ikkuna = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        ikkuna.setScene(kehys);
        ikkuna.show();

        }
}

