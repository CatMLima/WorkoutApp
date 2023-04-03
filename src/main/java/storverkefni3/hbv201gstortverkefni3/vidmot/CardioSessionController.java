package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.property.*;
import javafx.beans.value.*;
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

public class CardioSessionController implements Initializable{
    private ObservableList<Exercises> selectedExercises;
@FXML
    public Label fxExerciseName;
@FXML
    public Button fxSkipButton;
    public ImageView fxExerciseView;

    public Button fxStartButton;

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
            }
        else
            fxPauseButton.setText("Pause");
        clicks++;
        }
    public void fxStartExerciseHandler(ActionEvent actionEvent){

        
    }

    public void fxSkipExerciseHandler(ActionEvent actionEvent) {
        setCount(getCount()+1);
    }
}
