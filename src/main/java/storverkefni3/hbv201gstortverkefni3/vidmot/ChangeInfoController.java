package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChangeInfoController implements Initializable {
    public Button fxUpdate;
    public TextField fxAge;
    public TextField fxWeight;
    public TextField fxHeight;
    public TextField fxName;
    private Parent root;
    private Stage stage;
    private Scene scene;
    User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        fxName.setText(user.getName());
        fxAge.setText(String.valueOf(user.getAge()));
        fxHeight.setText(String.valueOf(user.getHeight()));
        fxWeight.setText(String.valueOf(user.getWeight()));
        fxUpdate.disableProperty().bind(Bindings.or(fxName.textProperty().isEmpty(),fxAge.textProperty().isEmpty()));
        fxUpdate.disableProperty().bind(Bindings.or(fxHeight.textProperty().isEmpty(), fxWeight.textProperty().isEmpty()));

    }

    public void backHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/user-page.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void updateHandler(ActionEvent actionEvent) throws IOException {
        user.setName(fxName.getText());
        user.setAge(Integer.parseInt(fxAge.getText()));
        user.setHeight(Integer.parseInt(fxHeight.getText()));
        user.setWeight(Integer.parseInt(fxWeight.getText()));

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/user-page.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
