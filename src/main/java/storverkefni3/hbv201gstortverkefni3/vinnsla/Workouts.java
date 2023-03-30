package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class Workouts {
   public Workouts(){
      workoutNames = FXCollections.observableArrayList();
      workout = FXCollections.observableArrayList();
arms = FXCollections.observableArrayList();
legs = FXCollections.observableArrayList();

   }
   //Brynjar Steinn worked on this class
   protected ObservableList<WorkoutName> workoutNames;
   protected ObservableList<Exercises> arms;
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
      List<Exercises> exerciseList = new ArrayList<>();
      ObservableList<Exercises> beingFiltered = getAllExercises();
      for (Exercises exercise : beingFiltered) {
         if (exercise.getWorkouttype().equals(goal)) {
            exerciseList.add(exercise);
            if (exercise.getBodypart().equals("arms")) {
               arms.add(exercise);
            }
         }
      }
      return FXCollections.observableArrayList(exerciseList);
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

