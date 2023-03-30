package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
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

    private Parent root;
    private Stage stage;
    private Scene scene;


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
        user.nameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                fxName.setText(s);
            }
        });
        user.ageProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fxAge.setText(String.valueOf(number));
            }
        });
        user.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fxHeight.setText(String.valueOf(number));
            }
        });
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
        user.setGoal(null);
        switchToWorkout(actionEvent);
    }

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

        switchToWorkout(actionEvent);

    }
    public void switchToWorkout(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
