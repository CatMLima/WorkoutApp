package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;

public class ChangeScene {
    /**
     * This class is initialized in every controller and gets used to move from fxml file to another.
     */
    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * Since the moves are always triggered by a button click, I am able to get the source of the action for the stage and then use the provided fxml file.
     * @param actionEvent
     * @param fxml
     * @throws IOException
     */
    public void changeTo(ActionEvent actionEvent, String fxml) throws IOException {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
