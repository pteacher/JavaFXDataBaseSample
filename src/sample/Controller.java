package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable, Refreshable {
    @FXML private TableView<Authors> table;
    @FXML private TableColumn<Authors, String> authorID;
    @FXML private TableColumn<Authors, String> firstName;
    @FXML private TableColumn<Authors, String> lastName;
    private int currentId = -1;

    @FXML
    public void addAuthor(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/modal/new.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @FXML
    public void updateTable(ActionEvent actionEvent) {
        table.getItems().setAll(Database.init());
        table.refresh();
    }

    @FXML
    public void deleteAuthor(ActionEvent actionEvent) {
        if (currentId != -1) {
            Database.deleteAuthor(currentId);
            table.getItems().setAll(Database.init());
        }

    }


    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 1)
        {
            System.out.println(table.getSelectionModel().getSelectedItem().getAuthorId());
            currentId = Integer.parseInt(table.getSelectionModel().getSelectedItem().getAuthorId());
        }
    }

    @Override
    public boolean isCurrent() {
        try {
            refresh();
        } catch (RefreshFailedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void refresh() throws RefreshFailedException {
        table.getItems().setAll(Database.init());
        table.refresh();
    }
}
