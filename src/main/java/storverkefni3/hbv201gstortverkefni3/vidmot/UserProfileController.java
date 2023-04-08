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
    private Parent root;
    private Stage stage;
    private Scene scene;
    User user;

    ObservableList<WorkoutName> workouts;

    WorkoutName workoutName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
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

    public void fxUpdateHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/change-credentials.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fxBackHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
