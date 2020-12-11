package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView<Authors> table;
    @FXML private TableColumn<Authors, String> authorID;
    @FXML private TableColumn<Authors, String> firstName;
    @FXML private TableColumn<Authors, String> lastName;

    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        authorID.setCellValueFactory(new PropertyValueFactory<Authors, String>("authorId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Authors, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Authors, String>("lastName"));

        Callback<TableColumn<Authors, String>, TableCell<Authors, String>> cellFactory
                = //
                new Callback<TableColumn<Authors, String>, TableCell<Authors, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Authors, String> param) {
                        final TableCell<Authors, String> cell = new TableCell<Authors, String>() {

                            final Button btn = new Button("1");
                            final Button btn2 = new Button("2");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                final Group gr = new Group();
                                gr.getChildren().add(btn);
                                gr.getChildren().add(btn2);
                                gr.minWidth(100);
                                gr.setAutoSizeChildren(true);
                                gr.prefWidth(100);

                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {

                                    });
                                    btn2.setOnAction(event -> {
                                        Authors person = getTableView().getItems().get(getIndex());
                                        System.out.println(person.getFirstName()
                                                + "   " + person.getLastName());
                                    });
                                    setGraphic(gr);
                                    setText(getTableView().getItems().get(getIndex()).getAuthorId());
                                }
                            }
                        };
                        return cell;
                    }
                };

        authorID.setCellFactory(cellFactory);

        table.getItems().setAll(Database.init());
    }

//    @FXML
//    public void addAuthor(ActionEvent actionEvent) {
//
//    }

    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 1) //Checking double click
        {
            System.out.println(table.getSelectionModel().getSelectedItem().getAuthorId());
            System.out.println(table.getSelectionModel().getSelectedItem().getFirstName());
            System.out.println(table.getSelectionModel().getSelectedItem().getLastName());

        }
    }

}
