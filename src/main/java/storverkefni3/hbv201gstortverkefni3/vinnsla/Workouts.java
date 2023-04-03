package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

//Brynjar Steinn worked on this class
public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
      workout = FXCollections.observableArrayList();
arms = FXCollections.observableArrayList();
legs = FXCollections.observableArrayList();

   }

   protected ObservableList<WorkoutName> workoutNames;
   public ObservableList<Exercises> arms;
protected ObservableList<Exercises> workout;
   public ObservableList<Exercises> legs;

   public ObservableList<Exercises> getAllExercises() {
      //exercise(WorkoutType,Bodypart,name,time,sets,reps)
workout.add(new Exercises("Muscle Gain","Arms","Curls",0.0,3,10,"storverkefni3/pics/BicepCurl.gif"));
      arms.add(new Exercises ("Muscle Gain","Arms","Hammer Curls",0.0,3,10,"storverkefni3/pics/HammerCurl.gif"));
      workout.add(new Exercises("Muscle Gain","Legs","Squats",0.0,3,10,"storverkefni3/pics/Squats.gif" ));
      workout.add(new Exercises("Weight loss","Jump Hard","Jumping jacks",30.0,0,0,"storverkefni3/pics/JumpingJacks.gif"));
return workout;
   }
   public ObservableList<Exercises> filterExercises(String goal) {
      List<Exercises> exerciseList = new ArrayList<>();
      ObservableList<Exercises> beingFiltered = getAllExercises();
      for (Exercises exercise : beingFiltered) {
         if (exercise.getWorkouttype().equals(goal)) {
            exerciseList.add(exercise);
            if (exercise.getBodypart().equals("Arms")) {
               arms.add(exercise);
            }
            if (exercise.getBodypart().equals("Legs")) {legs.add(exercise);}
         }
      }
      return FXCollections.observableArrayList(exerciseList);
   }
public Double getTotalTime(String goal){
   Double TotalTime = 0.0;
   ObservableList<Exercises> beingFiltered = StoreWorkout.getSelectedExercises();
      for (Exercises exercise : beingFiltered) {
      if (exercise.getWorkouttype().equals(goal)) {
         TotalTime += exercise.getTime();}
   }return TotalTime;
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

