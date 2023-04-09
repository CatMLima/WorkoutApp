package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import storverkefni3.hbv201gstortverkefni3.vinnsla.*;

import java.io.*;
import java.net.*;
import java.util.*;

/*
Catarina Lima worked on this class.
 */

public class ChangeInfoController implements Initializable {
    public Button fxUpdate;
    public TextField fxAge;
    public TextField fxWeight;
    public TextField fxHeight;
    public TextField fxName;
    private Parent root;
    private Stage stage;
    private Scene scene;

    ChangeScene changeScene;
    User user;

    /**
     * User can change their personal information aside from goals.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeScene = new ChangeScene();
        user = new User();
        fxName.setText(user.getName());
        fxAge.setText(String.valueOf(user.getAge()));
        fxHeight.setText(String.valueOf(user.getHeight()));
        fxWeight.setText(String.valueOf(user.getWeight()));
        fxUpdate.disableProperty().bind(Bindings.or(fxName.textProperty().isEmpty(),fxAge.textProperty().isEmpty()));
        fxUpdate.disableProperty().bind(Bindings.or(fxHeight.textProperty().isEmpty(), fxWeight.textProperty().isEmpty()));

    }

    /**
     * returns back to the previous page without saving information input
     * @param actionEvent
     * @throws IOException
     */
    public void backHandler(ActionEvent actionEvent) throws IOException {
        changeScene.changeTo(actionEvent, "/storverkefni3/hbv201gstortverkefni3/user-page.fxml");


    }

    /**
     * Anywhere new information was inserted, the user profile gets updated
     * @param actionEvent
     * @throws IOException
     */
    public void updateHandler(ActionEvent actionEvent) throws IOException {
        user.setName(fxName.getText());
        user.setAge(Integer.parseInt(fxAge.getText()));
        user.setHeight(Integer.parseInt(fxHeight.getText()));
        user.setWeight(Integer.parseInt(fxWeight.getText()));

        changeScene.changeTo(actionEvent, "/storverkefni3/hbv201gstortverkefni3/user-page.fxml");

    }
}
