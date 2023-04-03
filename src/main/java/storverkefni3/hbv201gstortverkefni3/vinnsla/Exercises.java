package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.beans.property.*;
import javafx.scene.image.Image;


public class Exercises {
    // Brynjar Steinn worked on this class
   // an exercise has a type like curls is a strength type and curls has reps and sets
    // but for cardio instead of reps it would have a time duration which would get added to a timer
    //an exercise has a name and a gif
    private StringProperty name=new SimpleStringProperty();
    private IntegerProperty reps = new SimpleIntegerProperty();
    private IntegerProperty sets=new SimpleIntegerProperty();
    private DoubleProperty time = new SimpleDoubleProperty();
    private StringProperty gif = new SimpleStringProperty();
    private StringProperty workouttype=new SimpleStringProperty();
    private StringProperty bodypart=new SimpleStringProperty();

    public String getGif() {
        return gif.get();
    }
    public String getWorkouttype() {
        return workouttype.get();
    }

    public String getBodypart() {
        return bodypart.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public void setWorkouttype(String workouttype) {
        this.workouttype.set(workouttype);
    }
    public void setBodypart(String bodypart) {
        this.bodypart.set(bodypart);
    }
    public Exercises(String workouttype, String bodypart, String name, double time, int sets, int reps, String gif) {
        setWorkouttype(workouttype);
        setBodypart(bodypart);
        setName(name);
        setTime(time); //if strength then this is null
        setSets(sets); //is null if not strength
        setReps(reps); //is null if not strength
        setGif(gif);
    }

    private void setReps(int reps) {
        this.reps.set(reps);
    }

    private void setSets(int sets) {
        this.sets.set(sets);
    }

    private void setTime(double time) {
        this.time.set(time);
    }
    public String getName(){
        return name.get();}
    public Double getTime(){
        return time.get();}
    public int getReps(){return reps.get();}
    public int getSets(){return sets.get();}
    @Override
    public String toString() {
        return getName() + " " + getTime() + " " + getSets()+ " " + getReps();

        }

    public void setGif(String gif) {
        this.gif.set(gif);
    }
}

