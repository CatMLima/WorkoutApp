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

    public Button fxBackButton;

    ChangeScene changeScene;
    User user;
    /**
     * List options created and set. Necessary bindings set.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = new User();
        changeScene = new ChangeScene();
        fxConfirm.disableProperty().bind(fxGoalsList.getSelectionModel().selectedItemProperty().isNull());
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Weight loss",
                        "Muscle Gain",
                        "Endurance"
                );
        fxGoalsList.setItems(options);
        createTooltips();
    }

    /**
     * Creates the Tool tips for each relevant fx tool.
     */

    public void createTooltips(){
        Tooltip back = new Tooltip("Return to workout page.");
        Tooltip.install(fxBackButton, back);
        Tooltip choices = new Tooltip("Select your new goal.");
        Tooltip.install(fxGoalsList, choices);
        Tooltip confirm = new Tooltip("Save new goal.");
        Tooltip.install(fxConfirm, confirm);
    }

    /**
     * Changes the goal selected by the user
     * @param actionEvent
     * @throws IOException
     */
    public void fxNewGoalHandler(ActionEvent actionEvent) throws IOException {
        user.setGoal(fxGoalsList.getSelectionModel().getSelectedItem().toString());
        changeScene.changeTo(actionEvent,Scenes.WORKOUT.getFileName());
    }
    /**
     * Go back to previous page
     * @param actionEvent
     * @throws IOException
     */
    public void fxReturnHandler(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent,Scenes.WORKOUT.getFileName());

    }
}
