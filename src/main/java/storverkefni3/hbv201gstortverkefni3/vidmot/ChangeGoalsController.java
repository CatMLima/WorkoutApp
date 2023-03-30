package storverkefni3.hbv201gstortverkefni3.vidmot;

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

public class ChangeGoalsController implements Initializable{
    @FXML
    ChoiceBox fxGoalsList;

    @FXML
    Button fxConfirm;
    public void fxReturnHandler(ActionEvent actionEvent) throws IOException {
        switchToWorkout(actionEvent);

    }

    User user;
    public void fxNewGoalHandler(ActionEvent actionEvent) throws IOException {
        user.setGoal(fxGoalsList.getSelectionModel().getSelectedItem().toString());
        switchToWorkout(actionEvent);
    }
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void switchToWorkout(ActionEvent event) throws IOException{
        root = FXMLLoader.load((getClass().getResource("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        fxConfirm.disableProperty().bind(fxGoalsList.getSelectionModel().selectedItemProperty().isNull());
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Weight loss",
                        "Muscle Gain",
                        "Endurance"
                );
        fxGoalsList.setItems(options);
    }
}
