package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
      workout = FXCollections.observableArrayList();
arms = FXCollections.observableArrayList();
legs = FXCollections.observableArrayList();

   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutName> workoutNames;
   protected ObservableList<WorkoutName> arms;
protected ObservableList<Exercises> workout;
   protected ObservableList<Exercises> legs;

   public ObservableList<Exercises> getAllExercises() {
      //exercise(name,time,sets,reps)
workout.add(new Exercises("Muscle Gain","Arms","Curls",0.0,3,10 ));
      workout.add(new Exercises("Muscle Gain","Legs","Squats",0.0,3,10 ));
      workout.add(new Exercises("Weight loss","Whole","Jumping jacks",30.0,0,0 ));
return workout;
   }
   public ObservableList<Exercises> filterExercises(String goal) {
      Workouts w= new Workouts();
      int count = 0;
      Exercises [] exercise = new Exercises[count+1];

      ObservableList<Exercises> beingFiltered = w.getAllExercises();
      for( int i = 0; i < beingFiltered.size(); i++){
         if (beingFiltered.get(i).getBodypart().equals(goal)){
            exercise[count] = beingFiltered.get(i);
            count++;
            //if (bodypart equals "arms" ){
            // arms.add(exercise(i)
            // }
         }
      }
      return FXCollections.observableArrayList(exercise);
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

