package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

/*
Catarina Lima worked on this class.
 */

public class WorkoutController implements Initializable {
    public Label fxExerciseMats;
    public Label fxResistanceBands;
    public Label fxGymMachines;
    public Label fxDumbbell;
    public Label fxBarbell;
    public Label fxKettlebell;
    public Circle fxKB;
    public Circle fxBB;
    public Circle fxDB;
    public Circle fxGM;
    public Circle fxRB;
    public Circle fxEM;
    public Button fxProfileButton;
    @FXML
    ListView fxWorkoutsListView;
    @FXML
    ListView fxExercisesListView;

    @FXML
    Button fxStartButton;
    @FXML
    Label fxUserLabel;

    @FXML
    Button fxLogOutButton;
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
        try {
            workoutnames.filterExercises(user.getGoal());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fxWorkoutsListView.setItems(workoutList);
        fxWorkoutsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println(newValue);
            if (newValue != null) {
                if ("Arms".equals(newValue.toString())) {
                    uncheckAll();
                    fxExercisesListView.setItems(workoutnames.arms);
                    filterCheck(workoutnames.arms);
                }
                if ("Legs".equals(newValue.toString())) {
                    uncheckAll();
                    fxExercisesListView.setItems(workoutnames.legs);
                    filterCheck(workoutnames.legs);}
                if ("Chest".equals(newValue.toString())) {
                        uncheckAll();
                        fxExercisesListView.setItems(workoutnames.chest);
                        filterCheck(workoutnames.legs);
                    }
            if ("Jump Hard".equals(newValue.toString())){
                    uncheckAll();
                    fxExercisesListView.setItems(workoutnames.JumpHard);
                    filterCheck(workoutnames.JumpHard);
                } if ("Cross Fit".equals(newValue.toString())){
                uncheckAll();
                fxExercisesListView.setItems(workoutnames.CrossFit);
                filterCheck(workoutnames.CrossFit);
            }
            }});
        testForGuestUser();
        fxStartButton.disableProperty().bind(fxWorkoutsListView.getSelectionModel().selectedItemProperty().isNull());

    }
    public void testForGuestUser(){
        if (user.getName().equals("guest") && user.getAge() == -1 && user.getHeight() == -1 && user.getWeight() == -1){
            fxLogOutButton.setText("Log in");
            fxProfileButton.setDisable(true);
        }
    }


    public void uncheckAll(){
        fxDB.setFill(WHITE);
        fxEM.setFill(WHITE);
        fxGM.setFill(WHITE);
        fxBB.setFill(WHITE);
        fxKB.setFill(WHITE);
        fxRB.setFill(WHITE);
    }
    Exercises[] exercises1;

    public void filterCheck(ObservableList<Exercises> exercises){
        exercises1 = new Exercises[6];
        exercises.toArray(exercises1);
        for (Exercises exercise: exercises){
            switch(exercise.getEquipment()){
                case "Kettlebell" -> fxKB.setFill(BLACK);
                case "Dumbbell" -> fxDB.setFill(BLACK);
                case "Resistance Bands" -> fxRB.setFill(BLACK);
                case "Barbell" -> fxBB.setFill(BLACK);
                case "Gym machines" -> fxGM.setFill(BLACK);
                case "Exercise Mats"-> fxEM.setFill(BLACK);
            }
        }
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

    public void profileHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/user-page.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
