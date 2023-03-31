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
    Label fxUserLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;

    User user;
    private Workouts workoutnames;

    ObservableList<WorkoutName> workoutList;

    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        workoutnames = new Workouts();
        fxUserLabel.setText("Hi, " + user.getName());
        workoutList = workoutnames.getAllWorkouts(user.getGoal());
        fxWorkoutsListView.setItems(workoutList);
        workoutnames.filterExercises(user.getGoal());

        //fxWorkoutsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
        //    @Override
        //    public void changed(ObservableValue observableValue, Object o, Object t1) {
        //        fxExercisesListView.setItems(workoutnames.filterExercises(String.valueOf(o)));
        //    }
        //});

        /*
        Bind fxExercisesListView to fxWorkoutsListView selected
         */
    }




    public void fxStartWorkoutHandler(ActionEvent actionEvent) throws IOException{

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
