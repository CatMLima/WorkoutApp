package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreWorkout {
    private static ObservableList<Exercises> selectedExercises;
    private static ObservableList<WorkoutName> selectedWorkout = FXCollections.observableArrayList();
    public static ObservableList<Exercises> getSelectedExercises() {
        return selectedExercises;
    }
    public static ObservableList<WorkoutName> getSelectedWorkout() {return selectedWorkout;}
    public static void setSelectedExercises(ObservableList<Exercises> selectedExercises) {
        StoreWorkout.selectedExercises = selectedExercises;
    }
    public static void setSelectedWorkout(String selectedWorkout) {
        StoreWorkout.selectedWorkout.clear();
        StoreWorkout.selectedWorkout.add(new WorkoutName(selectedWorkout));
    }
}
