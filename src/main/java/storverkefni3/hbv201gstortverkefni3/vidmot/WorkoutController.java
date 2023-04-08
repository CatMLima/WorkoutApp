package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.value.*;
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
        //displays clicked workouts exercises
        fxWorkoutsListView.setItems(workoutList);
        fxWorkoutsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
            //System.out.println(newValue);
                    displaySelectedWorkoutExercises(newValue.toString());

            }}); // Custom cell factory to display only the name variable
        fxExercisesListView.setCellFactory(param -> new ListCell<Exercises>() {
            @Override
            protected void updateItem(Exercises item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName()); // Only display the name variable
                }
            }
        });
        testForGuestUser();
        fxStartButton.disableProperty().bind(fxWorkoutsListView.getSelectionModel().selectedItemProperty().isNull());
    }
    private void displaySelectedWorkoutExercises(String workoutName) {if (workoutName != null) {
        /* Brynjar worked on this method
        checks which workout was clicked and populates the listview with the appropriate list
         */
        if ("Arms".equals(workoutName)) {
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.arms);
            filterCheck(workoutnames.arms);
            StoreWorkout.setSelectedWorkout(workoutName);
        }
        if ("Legs".equals(workoutName)) {
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.legs);
            filterCheck(workoutnames.legs);}
        StoreWorkout.setSelectedWorkout(workoutName);
        if ("Chest".equals(workoutName)) {
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.chest);
            filterCheck(workoutnames.legs);
            StoreWorkout.setSelectedWorkout(workoutName);
        }
        if ("Jump Hard".equals(workoutName)){
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.JumpHard);
            filterCheck(workoutnames.JumpHard);
            StoreWorkout.setSelectedWorkout(workoutName);
        } if ("Cross Fit".equals(workoutName)){
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.CrossFit);
            filterCheck(workoutnames.CrossFit);
            StoreWorkout.setSelectedWorkout(workoutName);
        } if ("Stamina Junkie".equals(workoutName)){
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.StaminaJunkie);
            filterCheck(workoutnames.StaminaJunkie);
            StoreWorkout.setSelectedWorkout(workoutName);
        } if ("Pump It Up".equals(workoutName)){
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.PumpItUp);
            filterCheck(workoutnames.PumpItUp);
            StoreWorkout.setSelectedWorkout(workoutName);
        } if ("Boxing Time".equals(workoutName)){
            uncheckAll();
            fxExercisesListView.setItems(workoutnames.BoxingTime);
            filterCheck(workoutnames.BoxingTime);
            StoreWorkout.setSelectedWorkout(workoutName);
        }
    }
    }

    /*
    Test that the user does not have an account, they have to log in and cannot view their profile (since it is nonexistent).
     */
    public void testForGuestUser(){
        if (user.getName().equals("guest") && user.getAge() == -1 && user.getHeight() == -1 && user.getWeight() == -1){
            fxLogOutButton.setText("Log in");
            fxProfileButton.setDisable(true);
        }
    }
    /*
    When clicking between workouts, this method makes sure to reset the Circles so that the right required equipment is shown.
     */
    public void uncheckAll(){
        fxDB.setFill(WHITE);
        fxEM.setFill(WHITE);
        fxGM.setFill(WHITE);
        fxBB.setFill(WHITE);
        fxKB.setFill(WHITE);
        fxRB.setFill(WHITE);
    }
    Exercises[] exercises1;

    /**
     * Check that the right boxes of equipment are checked
     * @param exercises workout selected by the user
     * Turns to black the Circles next to the equipment needed.
     */
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

    /*
    Checks the user goal and shows the correct fxml page. It can either contain a timer feature or contain repetition and sets (Cardio & Resistance versus Muscle Gain).
     */
    public void fxStartWorkoutHandler(ActionEvent actionEvent) throws IOException{
        String file = null;
        switch (user.getGoal()) {
            case "Weight loss" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-cardio-session.fxml";
            case "Muscle Gain" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-strength-session.fxml";
            case "Endurance" -> file = "/storverkefni3/hbv201gstortverkefni3/workout-cardio-session.fxml";
        }
        ObservableList<Exercises> selectedExercises = fxExercisesListView.getItems();
        StoreWorkout.setSelectedExercises(selectedExercises);
        StoreWorkout.addToLog(fxWorkoutsListView.getSelectionModel().getSelectedItem().toString());
        assert file != null;
        root = FXMLLoader.load((getClass().getResource(file)));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    /**
     * Erase user information and go back to initial page
     * @param actionEvent button pressed
     * @throws IOException fxml not valid
     * This should set all the user information to null, like a guest user and changes scenes.
     */
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

    /**
     * User wants to change their current goal.
     * @param actionEvent button is pushed
     * @throws IOException fxml page invalid
     * The user gets taken to another scene where they can change their goal.
     */

    public void fxChangeGoalsHandler(ActionEvent actionEvent) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/change-goals-view.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    /**
     * Take user to their profile
     * @param actionEvent button pressed
     * @throws IOException the fxml file is invalid
     * The user gets to see all the information they put in as well as their calculated BMI and history. They also have a chance to update their information.
     */

    public void profileHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/user-page.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
