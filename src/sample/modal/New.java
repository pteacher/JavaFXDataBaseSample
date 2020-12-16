package sample.modal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Authors;
import sample.Database;

import java.net.URL;
import java.util.ResourceBundle;

public class New implements Initializable {
    @FXML private TextField name;
    @FXML private TextField lastname;

    @FXML
    public void addNewAuthor(ActionEvent actionEvent) {
        Database.addAuthor(new Authors(Integer.toString(0), name.getText(), lastname.getText()));
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
