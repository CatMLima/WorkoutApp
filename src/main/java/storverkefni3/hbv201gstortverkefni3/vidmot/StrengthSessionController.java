package storverkefni3.hbv201gstortverkefni3.vidmot;


import javafx.beans.property.*;
import javafx.beans.value.*;

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
    public Button fxQuitButton;
    private ObservableList<Exercises> selectedExercises;

    public Label fxExerciseName;
    public Label fxWorkoutLabel;
    public Button fxContinueButton;
    public Label fxRepetitions;
    public Label fxSets;
    public ImageView fxExerciseView;
    User user;
    ChangeScene changeScene;

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

    /**
     * Exercises imported based on selected workout. Listeners and binds set.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        changeScene = new ChangeScene();
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
        fxContinueButton.disableProperty().bind(countProperty().isEqualTo(exercises.length-1));
        createToolTips();

    }
    /**
     * Creates the relevant Tool Tips for the FX tools.
     */
    public void createToolTips(){
        Tooltip quit = new Tooltip("Return to the workout page.");
        Tooltip.install(fxQuitButton, quit);
        Tooltip next = new Tooltip("Next exercise");
        Tooltip.install(fxContinueButton, next);

    }

    /**
     * Based on the exercise, the name, rep and sets need to be added. The code was moved here to maintain cleanliness in initialize.
     * @param count
     */
    public void setNameRepSets(int count){
        fxExerciseName.setText(exercises[count].getName());
        fxRepetitions.setText(String.valueOf(exercises[count].getReps()));
        fxSets.setText(String.valueOf(exercises[count].getSets()));
        fxExerciseView.setImage(new Image(getClass().getResourceAsStream(exercises[count].getGif())));
        //could have an if here where if(url not found) then display some image not found picture
    }

    /**
     * User returns to previous page without or after finishing the workout.
     * @param actionEvent
     * @throws IOException
     */
    public void fxQuitWorkoutHandler(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent, Scenes.WORKOUT.getFileName());
    }

    /**
     * Next exercise comes up.
     * @param actionEvent
     */
    public void fxContinueExerciseHandler(ActionEvent actionEvent) {
        setCount(getCount()+1);
        if (getCount() == exercises.length-1){
            fxQuitButton.textProperty().set("Finish");
        }
    }
}
