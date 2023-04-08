package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Brynjar Steinn worked on this class
public class Workouts {
   public Workouts(){
      //creates observablelist that gets used in methods
      workoutNames = FXCollections.observableArrayList();
      workout = FXCollections.observableArrayList();
      //creates the list of exercises in the preview window
arms = FXCollections.observableArrayList();
legs = FXCollections.observableArrayList();
JumpHard = FXCollections.observableArrayList();
CrossFit = FXCollections.observableArrayList();
chest = FXCollections.observableArrayList();
StaminaJunkie = FXCollections.observableArrayList();
PumpItUp = FXCollections.observableArrayList();
BoxingTime = FXCollections.observableArrayList();
back = FXCollections.observableArrayList();
   }

   protected ObservableList<WorkoutName> workoutNames;
   public ObservableList<Exercises> arms;
protected ObservableList<Exercises> workout;
   public ObservableList<Exercises> legs;
   public ObservableList<Exercises> JumpHard;
   public ObservableList<Exercises> CrossFit;
   public ObservableList<Exercises> chest;
   public ObservableList<Exercises> StaminaJunkie;
   public ObservableList<Exercises> PumpItUp;
   public ObservableList<Exercises> back;
   public ObservableList<Exercises> BoxingTime;


   public ObservableList<Exercises> getAllExercises() throws IOException {
      InputStream inputStream = getClass().getResourceAsStream("/storverkefni3/hbv201gstortverkefni3/Exercises.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = reader.readLine()) != null) {
         if (line.startsWith("#")) {
            continue; // ignore comment lines
         }
         //reads the exercises.txt and adds it to the workouts list
         String[] tokens = line.split(",");
         String workoutType = tokens[0].replace("\"", "");
         String bodypart = tokens[1].replace("\"", "");
         String name = tokens[2].replace("\"", "");
         double time = Double.parseDouble(tokens[3]);
         int sets = Integer.parseInt(tokens[4]);
         int reps = Integer.parseInt(tokens[5]);
         String gif = tokens[6].replace("\"", "");
         String equipment = tokens[7].replace("\"", "");

         workout.add(new Exercises(workoutType, bodypart, name, time, sets, reps, gif, equipment));
      }
      return workout;
   }

   public ObservableList<Exercises> filterExercises(String goal) throws IOException {
      //filters workouts list and puts it into the appropriate list
      List<Exercises> exerciseList = new ArrayList<>();
      ObservableList<Exercises> beingFiltered = getAllExercises();
      for (Exercises exercise : beingFiltered) {
         if (exercise.getWorkouttype().equals(goal)) {
            exerciseList.add(exercise);
            if (exercise.getBodypart().equals("Arms")) {
               arms.add(exercise);
            }if (exercise.getBodypart().equals("Chest")) {
               chest.add(exercise);
            }
            if (exercise.getBodypart().equals("Back")) {
              back.add(exercise);}
            if (exercise.getBodypart().equals("Legs")) {legs.add(exercise);}
         } if (exercise.getBodypart().equals("Jump Hard")) {JumpHard.add(exercise);}
         if (exercise.getBodypart().equals("Cross Fit")) {CrossFit.add(exercise);}
         if (exercise.getBodypart().equals("Stamina Junkie")){ StaminaJunkie.add(exercise);}
         if (exercise.getBodypart().equals("Pump It Up")){ PumpItUp.add(exercise);}
         if (exercise.getBodypart().equals("Boxing Time")){ BoxingTime.add(exercise);}
      }

      return FXCollections.observableArrayList(exerciseList);
   }
public Double getTotalTime(String goal){
      //a method to get the total time of a workout
   Double TotalTime = 0.0;
   ObservableList<Exercises> beingFiltered = StoreWorkout.getSelectedExercises();
      for (Exercises exercise : beingFiltered) {
      if (exercise.getWorkouttype().equals(goal)) {
         TotalTime += exercise.getTime();}
   }return TotalTime;
}

   public ObservableList<WorkoutName> getAllWorkouts(String type) {
      //creates the names of the workouts. (could be replaced with another text file reading)
      switch (type) {
         case "Weight loss" -> {
            workoutNames.add(new WorkoutName("Jump Hard"));
            workoutNames.add(new WorkoutName("Cross Fit"));
            workoutNames.add(new WorkoutName("Boxing Time"));
         }
         case "Muscle Gain" -> {
            workoutNames.add(new WorkoutName("Arms"));
            workoutNames.add(new WorkoutName("Legs"));
            workoutNames.add(new WorkoutName("Chest"));
            workoutNames.add(new WorkoutName("Back"));
         }
         case "Endurance" ->{
            workoutNames.add(new WorkoutName("Stamina Junkie"));
            workoutNames.add(new WorkoutName("Cross Fit"));
            workoutNames.add(new WorkoutName("Pump It Up"));
         }

      }
      return workoutNames;
   }}

