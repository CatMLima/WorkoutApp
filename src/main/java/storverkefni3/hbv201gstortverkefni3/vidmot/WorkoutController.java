package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

/*
Catarina Lima worked on this class.
 */

public class WorkoutController implements Initializable {
    @FXML
    ListView fxWorkoutsListView;
    @FXML
    ListView fxExercisesListView;

    @FXML
    Button fxStartButton;
    @FXML
    Label fxUserLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;

    User user;

    private Workouts workoutnames;

    ObservableList<WorkoutName> workoutList;

    /*
    Catarina and Brynjar worked on the initialize method
     */
    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        workoutnames = new Workouts();
        fxUserLabel.setText("Hi, " + user.getName());
        workoutList = workoutnames.getAllWorkouts(user.getGoal());
        workoutnames.filterExercises(user.getGoal());
        fxWorkoutsListView.setItems(workoutList);
        fxWorkoutsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println(newValue);
            if (newValue != null) {
                if ("Arms".equals(newValue.toString())) {
                    fxExercisesListView.setItems(workoutnames.arms);
                }
                if ("Legs".equals(newValue.toString())) {
                    fxExercisesListView.setItems(workoutnames.legs);
            } if ("Jump Hard".equals(newValue.toString())){
                    fxExercisesListView.setItems(workoutnames.JumpHard);
                }
            }});
        fxStartButton.disableProperty().bind(fxWorkoutsListView.getSelectionModel().selectedItemProperty().isNull());

    }




    public void fxStartWorkoutHandler(ActionEvent actionEvent) throws IOException{
        String file = null;
        switch (user.getGoal()) {
            case "Weight loss" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-cardio-session.fxml";
            case "Muscle Gain" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-strength-session.fxml";
            case "Endurance" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-cardio-session.fxml";
        }
        ObservableList<Exercises> selectedExercises = fxExercisesListView.getItems();
        StoreWorkout.setSelectedExercises(selectedExercises);
        assert file != null;
        root = FXMLLoader.load((getClass().getResource(file)));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void fxLogOutHandler(ActionEvent actionEvent) throws IOException{
            root = FXMLLoader.load((getClass().getResource("/storverkefni3/hbv201gstortverkefni3/initial-page-view.fxml")));
            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            user.setName("");
            user.setAge(-1);
            user.setHeight(-1);
            user.setWeight(-1);
            user.setGoal(null);
            stage.show();
    }

    public void fxChangeGoalsHandler(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/change-goals-view.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }

}
