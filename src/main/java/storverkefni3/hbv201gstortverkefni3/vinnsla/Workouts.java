package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Workouts {
   public Workouts(){workouts = FXCollections.observableArrayList();
   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutGenerator> workouts;
   protected ObservableList<Exercises> weightloss;
protected ObservableList<Exercises> musclegainarms;

   public ObservableList<Exercises> getAllArmsMusclegainExercises() {
      //exercise(name,time,sets,reps)
this.musclegainarms.add(new Exercises("Curls",0.0,3,10 ));
return this.musclegainarms;
   }
   public ObservableList<Exercises> getAllWeightlossExercises() {
      //exercise(name,time,sets,reps)
      weightloss.add(new Exercises("Jumping jacks",30.0,0,0 ));
      return weightloss;
   }
   public ObservableList<WorkoutGenerator> getAllMusclegainWorkouts() {
      workouts.add(new WorkoutGenerator("Arms")); //doesnt work
      return workouts;
   }
   public static void main(String[] args) {
Workouts w = new Workouts();
w.getAllMusclegainWorkouts();
      System.out.println(w);
   }
}

