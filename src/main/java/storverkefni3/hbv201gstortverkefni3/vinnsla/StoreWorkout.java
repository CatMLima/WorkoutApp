package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
/* a class to store workouts and exercise lists */
public class StoreWorkout {
    private static ObservableList<Exercises> selectedExercises;
    private static ObservableList<WorkoutName> selectedWorkout = FXCollections.observableArrayList();
    public static ObservableList<Exercises> getSelectedExercises() {
        return selectedExercises;
    }
    public static ObservableList<WorkoutName> getSelectedWorkout() {return selectedWorkout;}

    private static ObservableList<WorkoutName> logWorkouts = FXCollections.observableArrayList();

    public static ObservableList<WorkoutName> getLogWorkouts(){return logWorkouts;}
    public static void setSelectedExercises(ObservableList<Exercises> selectedExercises) {
        StoreWorkout.selectedExercises = selectedExercises;
    }
    public static void setSelectedWorkout(String selectedWorkout) {
        StoreWorkout.selectedWorkout.clear();
        StoreWorkout.selectedWorkout.add(new WorkoutName(selectedWorkout));
    }
    public static void addToLog(String selectedWorkout){
        StoreWorkout.logWorkouts.add(new WorkoutName(selectedWorkout));
    }
}
