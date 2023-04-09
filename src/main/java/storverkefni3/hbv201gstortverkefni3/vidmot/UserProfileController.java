package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
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

public class UserProfileController implements Initializable {

    public Label fxName;
    public Label fxAge;
    public Label fxHeight;
    public Label fxWeight;
    public Label fxBMI;
    public ImageView fxUserIcon;
    public Label fxGoal;
    public ListView fxWorkoutHistory;
    User user;

    ChangeScene changeScene;

    ObservableList<WorkoutName> workouts;

    WorkoutName workoutName;

    /**
     * Information imported from the static user information.
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        changeScene = new ChangeScene();
        workouts = StoreWorkout.getLogWorkouts();
        fxWorkoutHistory.setItems(workouts);
        fxName.setText(user.getName());
        fxAge.setText(String.valueOf(user.getAge()));
        fxHeight.setText(String.valueOf(user.getHeight()));
        fxWeight.setText(String.valueOf(user.getWeight()));
        double value = User.calculateBMI(user.getHeight(), user.getWeight());
        fxBMI.setText(String.format("%.1f", value));
        fxUserIcon.setImage(new Image(getClass().getResourceAsStream("/storverkefni3/pics/user-profile-logo.png")));
        fxGoal.setText(user.getGoal());

    }

    /**
     * User can update their information, perhaps a change of name, height, weight.
     * @param actionEvent
     * @throws IOException
     */

    public void fxUpdateHandler(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent,Scenes.CHANGEINFO.getFileName());
    }

    /**
     * return to previous page with or without having changed their personal information
     * @param actionEvent
     * @throws IOException
     */

    public void fxBackHandler(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent,Scenes.WORKOUT.getFileName());
    }
}
