package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

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
    Label fxUserLabel;

    User user;
    private Workouts workoutnames;

    ObservableList<Exercises> workoutList;
    //brynjar steinn worked on this method
    public void whichtype(String type){
        switch (type) {
            case "Weight loss":
        workoutList = workoutnames.getAllWeightlossExercises();
        break;
            case    "Muscle Gain":
            workoutList = workoutnames.getAllMusclegainExercises();
            break;
            case "Endurance":
                workoutList = workoutnames.getAllWeightlossExercises();
                break;
    }
   // fxWorkoutsListView.setItems(workoutnames);
        }


    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        workoutnames = new Workouts();
        fxUserLabel.setText("Hi, " + user.getName());
        whichtype(user.getGoal());
        fxWorkoutsListView.setItems(workoutList);
        /*
        Bind fxExercisesListView to fxWorkoutsListView selected
         */
    }




    public void fxStartWorkoutHandler(ActionEvent actionEvent) {
    }

    public void fxLogOutHandler(ActionEvent actionEvent) {

    }

    public void fxChangeGoalsHandler(ActionEvent actionEvent) {
    }

}
