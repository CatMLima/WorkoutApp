package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.util.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class CardioSessionController implements Initializable{
    private ObservableList<Exercises> selectedExercises;
@FXML
    public Label fxExerciseName;
@FXML
    public Button fxNextButton;
    public ImageView fxExerciseView;

    public Button fxStartButton;

    public Button fxQuitButton;

    @FXML
    public Label fxTimer;
    @FXML
    public Button fxPauseButton;
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

    ChangeScene changeScene;

    final double TIME = 31.0;

    Timeline timeline;

    /**
     * exercises imported based on workout selected and gifs set
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
        setNameGif(getCount());
        countProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    setNameGif((Integer) t1);
            }
        });
        fxPauseButton.disableProperty().bind(fxTimer.textProperty().isEmpty());
        fxNextButton.disableProperty().bind(countProperty().isEqualTo(exercises.length-1));
        createTooltips();
    }
    /**
     * Creates the relevant Tool Tips for the FX tools.
     */
    public void createTooltips(){
        Tooltip quit = new Tooltip("Return to the workout page.");
        Tooltip.install(fxQuitButton, quit);
    }

    /**
     * Handling the setting of the image to something else to clear up initialize method
     * @param count
     */
    public void setNameGif(int count){
        fxExerciseName.setText(exercises[count].getName());
        fxExerciseView.setImage(new Image(getClass().getResourceAsStream(exercises[count].getGif())));

    }

    /**
     * User can return to previous page
     * @param actionEvent
     * @throws IOException
     */
    public void fxQuitWorkoutHandler(ActionEvent actionEvent) throws IOException {
       changeScene.changeTo(actionEvent, Scenes.WORKOUT.getFileName());
    }

    int clicks = 0;

    /**
     * Timer can be paused and the button text is updated
     * @param actionEvent
     */

    public void fxPauseExerciseHandler(ActionEvent actionEvent) {

        if (clicks == 0 || clicks % 2 == 0 ){
            fxPauseButton.setText("Continue");
            timeline.pause();
            }
        else {
            fxPauseButton.setText("Pause");
            timeline.play();
        }
        clicks++;
        }

    /**
     * The timeline is started from the beginning and also rules for what to display when 0 are set.
     * @param actionEvent
     */
    public void fxStartExerciseHandler(ActionEvent actionEvent){
        setTime(TIME);
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event ->{
                    setTime(getTime()-1);
                    fxTimer.setText(String.valueOf(getTime()));
                    if (getTime() <= 0){
                        timeline.stop();
                        fxTimer.setText("Done");
                    }
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();
        fxStartButton.setDisable(true);
    }

    public void fxNextExerciseHandler(ActionEvent actionEvent) {
        setCount(getCount() + 1);
        /*
        In case a timeline was never begun because a user skipped an exercise, the exception is handled
         */
        if (getCount() == exercises.length-1){
            fxQuitButton.textProperty().set("Finish");
        }
        if (timeline != null)
            timeline.stop();
        fxTimer.setText("");
        fxStartButton.setDisable(false);
    }

    public double getTime() {
        return time.get();
    }

    public DoubleProperty timeProperty() {
        return time;
    }

    public void setTime(double time) {
        this.time.set(time);
    }

    DoubleProperty time = new SimpleDoubleProperty();
}
