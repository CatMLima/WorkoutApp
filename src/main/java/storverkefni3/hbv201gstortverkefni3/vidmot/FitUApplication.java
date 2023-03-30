package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class FitUApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FitUApplication.class.getResource("/storverkefni3/hbv201gstortverkefni3/initial-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        /*
        Maybe I will be able to implement the view switcher feature later.
         */
        //var scene = new Scene(new Pane());
        //ViewSwitcher.setScene(scene);
        //ViewSwitcher.switchTo(View.MAIN);
        stage.setScene(scene);
        stage.setTitle("Fit-U Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
