package storverkefni3.hbv201gstortverkefni3.vidmot;


import javafx.collections.*;

import javafx.collections.ObservableList;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;

import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import storverkefni3.hbv201gstortverkefni3.vinnsla.Exercises;
import storverkefni3.hbv201gstortverkefni3.vinnsla.StoreWorkout;


import java.io.*;
import java.net.*;
import java.util.*;

public class StrengthSessionController implements Initializable {
    private ObservableList<Exercises> selectedExercises;

    public Label fxExerciseName;
    public Label fxWorkoutLabel;
    public Button fxSkipButton;
    public Label fxRepetitions;
    public Label fxSets;
    public ImageView fxExerciseView;
    private Parent root;
    private Stage stage;
    private Scene scene;

    User user;

    Workouts workout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        workout = new Workouts();
        selectedExercises = StoreWorkout.getSelectedExercises();

    }

    public void fxQuitWorkoutHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fxSkipExerciseHandler(ActionEvent actionEvent) {
    }
}
