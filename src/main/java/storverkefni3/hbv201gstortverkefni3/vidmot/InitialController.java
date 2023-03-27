package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class InitialController implements Initializable {
    public ImageView fxUserImage;
    public TextField fxAge;
    public TextField fxWeight;
    public TextField fxHeight;
    public TextField fxName;
    public ChoiceBox fxGoalChoices;
    public Button fxConfirmButton;
    public Button fxGuestButton;

    public User user;

    public void initialize(URL location, ResourceBundle resources) {
        fxConfirmButton.disableProperty().bind(Bindings.or(fxName.textProperty().isEmpty(),fxAge.textProperty().isEmpty()));
        fxConfirmButton.disableProperty().bind(Bindings.or(fxHeight.textProperty().isEmpty(), fxWeight.textProperty().isEmpty()));
        fxConfirmButton.disableProperty().bind(fxGoalChoices.getSelectionModel().selectedItemProperty().isNull());
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Weight loss",
                        "Muscle Gain",
                        "Endurance"
                );
        fxGoalChoices.setItems(options);

    }


    public void guestHandler(ActionEvent actionEvent) {
        user = new User("guest", -1,-1,-1,null);
    }

    public void confirmHandler(ActionEvent actionEvent) {
        int age = Integer.parseInt(fxAge.getText());
        int height = Integer.parseInt(fxHeight.getText());
        int weight = Integer.parseInt(fxWeight.getText());
        String goal = fxGoalChoices.getSelectionModel().getSelectedItem().toString();
        user = new User(fxName.getText(), age, height, weight, goal);
    }
}
