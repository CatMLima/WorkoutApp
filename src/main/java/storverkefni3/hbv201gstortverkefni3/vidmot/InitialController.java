package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

/*
Author: Catarina Martins Sousa Lima
 */

public class InitialController implements Initializable {
    public ImageView fxUserImage;
    public TextField fxAge;
    public TextField fxWeight;
    public TextField fxHeight;
    public TextField fxName;
    public ChoiceBox fxGoalChoices;
    public Button fxConfirmButton;
    public Button fxGuestButton;
    ChangeScene changeScene;

    public User user;

    public void initialize(URL location, ResourceBundle resources) {
        /*
        The Confirm button is disabled unless all information is filled and the choice of goals is made
         */
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
        textFilter();
        changeScene = new ChangeScene();
        createTootips();
    }
    public void createTootips(){
        Tooltip tooltip = new Tooltip("Confirm your choice");
        Tooltip.install(fxConfirmButton,tooltip);
        Tooltip tooltip1 = new Tooltip("Enter your name.");
        Tooltip.install(fxName,tooltip1);
        Tooltip tooltip2 = new Tooltip("Enter your age.");
        Tooltip.install(fxAge, tooltip2);
        Tooltip tooltip3 = new Tooltip("Enter your height in centimeters.");
        Tooltip.install(fxHeight, tooltip3);
        Tooltip tooltip4 = new Tooltip("Enter your weight in kilograms.");
        Tooltip.install(fxWeight, tooltip4);
        Tooltip tooltip5 = new Tooltip("Choose your goal.");
        Tooltip.install(fxGoalChoices, tooltip5);
        Tooltip tooltip6 = new Tooltip("Skip entering your information.");
        Tooltip.install(fxGuestButton, tooltip6);
    }

    /**
     * Method makes sure that the User input is filtered to only be String in names and Integers for the rest.
     */
    public void textFilter(){
        fxName.textProperty().addListener((observable, oldValue, newValue) ->{
            String filteredText = newValue.replaceAll("[^\\p{L}\\s]", "");
            fxName.setText(filteredText);
        } );
        TextFormatter<Integer> formatter = new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });
        fxAge.setTextFormatter(formatter);
        TextFormatter<Integer> formatter2 = new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });
        fxHeight.setTextFormatter(formatter2);
        TextFormatter<Integer> formatter3 = new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });
        fxWeight.setTextFormatter(formatter3);

    }

    /*
    In case that the user does not want to give up their name, then we can take them to the next screen where they see
    all possible workouts, not just 6 (2 for each body part).
     */

    public void guestHandler(ActionEvent actionEvent) throws IOException {
        user = new User();
        user.setName("guest");
        user.setAge(-1);
        user.setHeight(-1);
        user.setWeight(-1);
        user.setGoal("none");
        pickGoal(actionEvent);

    }

    /**
     * If the user will be a guest, they still need to select their personal goal.
     * @param actionEvent button pressed
     * @throws IOException no valid fxml
     */
    public void pickGoal(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent,Scenes.CHANGEGOALS.getFileName());
    }

    /**
     * When the user fills in all their information their profile is created and goal registered
     * @param actionEvent button pushed
     * @throws IOException no valid fxml
     */

    public void confirmHandler(ActionEvent actionEvent) throws IOException {
        user = new User();
        int age = Integer.parseInt(fxAge.getText());
        int height = Integer.parseInt(fxHeight.getText());
        int weight = Integer.parseInt(fxWeight.getText());
        String goal = fxGoalChoices.getSelectionModel().getSelectedItem().toString();
        user.setName(fxName.getText());
        user.setAge(age);
        user.setHeight(height);
        user.setWeight(weight);
        user.setGoal(goal);

       changeScene.changeTo(actionEvent,Scenes.WORKOUT.getFileName());

    }

}
