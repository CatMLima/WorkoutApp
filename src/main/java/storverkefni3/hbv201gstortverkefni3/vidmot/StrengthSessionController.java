package storverkefni3.hbv201gstortverkefni3.vidmot;


import javafx.beans.property.*;
import javafx.beans.value.*;
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

    Exercises[] exercises;

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    IntegerProperty count = new SimpleIntegerProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        setCount(0);
        workout = new Workouts();
        selectedExercises = StoreWorkout.getSelectedExercises();
        exercises = new Exercises[selectedExercises.size()];
        selectedExercises.toArray(exercises);
        setNameRepSets(getCount());
        countProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                setNameRepSets((Integer) t1);
            }
        });

    }
    public void setNameRepSets(int count){
        fxExerciseName.setText(exercises[count].getName());
        fxRepetitions.setText(String.valueOf(exercises[count].getReps()));
        fxSets.setText(String.valueOf(exercises[count].getSets()));
        fxExerciseView.setImage(new Image("src/main/resources/storverkefni3/pics/BicepCurl.gif"));
    }


    public void fxQuitWorkoutHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BicepCurl.gif")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fxContinueExerciseHandler(ActionEvent actionEvent) {
        setCount(getCount()+1);
    }
}
