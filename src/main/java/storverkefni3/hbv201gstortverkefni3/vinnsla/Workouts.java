package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Workouts {
   //Brynjar Steinn worked on this class
   protected ObservableList<Exercises> workout;

   public ObservableList<Exercises> getAllMusclegainExercises() {
      //exercise(name,time,sets,reps)
workout.add(new Exercises("Curls",0.0,3,10 ));
return workout;
   }
   public ObservableList<Exercises> getAllWeightlossExercises() {
      //exercise(name,time,sets,reps)
      workout.add(new Exercises("Jumping jacks",30.0,0,0 ));
      return workout;
   }
}
// if (time != 0){then add time?}
