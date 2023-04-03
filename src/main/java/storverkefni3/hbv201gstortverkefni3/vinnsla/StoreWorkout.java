package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.ObservableList;

public class StoreWorkout {
    private static ObservableList<Exercises> selectedExercises;

    public static ObservableList<Exercises> getSelectedExercises() {
        return selectedExercises;
    }

    public static void setSelectedExercises(ObservableList<Exercises> selectedExercises) {
        StoreWorkout.selectedExercises = selectedExercises;
    }
}
