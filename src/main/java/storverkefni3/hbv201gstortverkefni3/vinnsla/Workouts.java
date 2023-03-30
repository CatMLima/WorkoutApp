package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
      musclegain = FXCollections.observableArrayList();
      weightloss = FXCollections.observableArrayList();
   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutName> workoutNames;
   protected ObservableList<Exercises> weightloss;
protected ObservableList<Exercises> musclegain;

   public ObservableList<Exercises> getAllMusclegainExercises() {
      //exercise(name,time,sets,reps)
musclegain.add(new Exercises("Muscle Gain","Curls",0.0,3,10 ));
      musclegain.add(new Exercises("Muscle Gain","Squats",0.0,3,10 ));
return musclegain;
   }
   public ObservableList<Exercises> getAllWeightlossExercises() {
      //exercise(name,time,sets,reps)
      weightloss.add(new Exercises("Weight loss","Jumping jacks",30.0,0,0 ));
      return weightloss;
   }
   public ObservableList<WorkoutName> getAllMusclegainWorkouts() {
      workoutNames.add(new WorkoutName("Arms"));
      workoutNames.add(new WorkoutName("Legs"));
      return workoutNames;
   }
   public ObservableList<WorkoutName> getAllWeightlossWorkouts() {
      workoutNames.add(new WorkoutName("Jump Hard"));
      return workoutNames;
   }
   public static void main(String[] args) {
Workouts w = new Workouts();
w.getAllMusclegainWorkouts();
      System.out.println(w);
   }
}

