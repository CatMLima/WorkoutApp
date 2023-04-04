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
    public Button fxSkipButton;
    public ImageView fxExerciseView;

    public Button fxStartButton;

    @FXML
    public Label fxTimer;
    @FXML
    public Button fxPauseButton;

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

    final double TIME = 61.0;

    Timeline timeline;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
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
        fxStartButton.disableProperty().bind(fxTimer.textProperty().isNotEmpty());
        fxPauseButton.disableProperty().bind(fxTimer.textProperty().isEmpty());
    }
    public void setNameGif(int count){
        fxExerciseName.setText(exercises[count].getName());
        fxExerciseView.setImage(new Image(getClass().getResourceAsStream(exercises[count].getGif())));

    }


    public void fxQuitWorkoutHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    int clicks = 0;

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
    public void fxStartExerciseHandler(ActionEvent actionEvent){
        timeline.playFromStart();
    }

    public void fxSkipExerciseHandler(ActionEvent actionEvent) {
        setCount(getCount()+1);
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
