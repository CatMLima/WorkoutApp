package storverkefni3.hbv201gstortverkefni3.vidmot;

import javafx.fxml.*;
import javafx.scene.*;

import java.io.*;
import java.util.*;

public class ViewSwitcher {
    private static Map<View, Parent> cache = new HashMap<>();

    private static Scene scene;

    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    /**
     * Method used to load in a different fxml file. It makes use of the enumeration View to find the right fxml file name
     * @param view
     */

    public static void switchTo(View view){
        if (scene == null){
            System.out.println("No scene was set");
            return;
        }
        try{
            Parent root;
            if(cache.containsKey(view)){
                root = cache.get(view);
            }
            else{
                root = FXMLLoader.load(
                        ViewSwitcher.class.getResource(view.getFileName()));
                cache.put(view, root);
            }
            scene.setRoot(root);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
