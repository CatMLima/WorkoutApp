package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
      workout = FXCollections.observableArrayList();

   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutName> workoutNames;

protected ObservableList<Exercises> workout;

   public ObservableList<Exercises> getAllExercises() {
      //exercise(name,time,sets,reps)
workout.add(new Exercises("Muscle Gain","Arms","Curls",0.0,3,10 ));
      workout.add(new Exercises("Muscle Gain","Legs","Squats",0.0,3,10 ));
      workout.add(new Exercises("Weight loss","Whole","Jumping jacks",30.0,0,0 ));
return workout;
   }

   public ObservableList<WorkoutName> getAllWorkouts(String type) {
      switch (type) {
         case "Weight loss" -> workoutNames.add(new WorkoutName("Jump Hard"));
         case "Muscle Gain" -> {
            workoutNames.add(new WorkoutName("Arms"));
            workoutNames.add(new WorkoutName("Legs"));
         }
         case "Endurance" -> workoutNames.add(new WorkoutName("idnoman"));
      }
      return workoutNames;
   }}

