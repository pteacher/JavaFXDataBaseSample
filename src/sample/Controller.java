package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView<Authors> table;
    @FXML private TableColumn<Authors, String> authorID;
    @FXML private TableColumn<Authors, String> firstName;
    @FXML private TableColumn<Authors, String> lastName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authorID.setCellValueFactory(new PropertyValueFactory<Authors, String>("authorId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Authors, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Authors, String>("lastName"));
        table.getItems().setAll(Database.init());
    }
}
