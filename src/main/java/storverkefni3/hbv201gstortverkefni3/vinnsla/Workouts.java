package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutGenerator> workoutNames;
   protected ObservableList<Exercises> weightloss;
protected ObservableList<Exercises> musclegainarms;

   public ObservableList<Exercises> getAllArmsMusclegainExercises() {
      //exercise(name,time,sets,reps)
musclegainarms.add(new Exercises("Curls",0.0,3,10 ));
return musclegainarms;
   }
   public ObservableList<Exercises> getAllLegsMusclegainExercises() {
      //exercise(name,time,sets,reps)
      musclegainarms.add(new Exercises("Squats",0.0,3,10 ));
      return musclegainarms;
   }
   public ObservableList<Exercises> getAllWeightlossExercises() {
      //exercise(name,time,sets,reps)
      weightloss.add(new Exercises("Jumping jacks",30.0,0,0 ));
      return weightloss;
   }
   public ObservableList<WorkoutGenerator> getAllMusclegainWorkouts() {
      workoutNames.add(new WorkoutGenerator("Arms"));
      workoutNames.add(new WorkoutGenerator("Legs"));
      return workoutNames;
   }
   public ObservableList<WorkoutGenerator> getAllWeightlossWorkouts() {
      workoutNames.add(new WorkoutGenerator("Jump Hard"));
      return workoutNames;
   }
   public static void main(String[] args) {
Workouts w = new Workouts();
w.getAllMusclegainWorkouts();
      System.out.println(w);
   }
}

