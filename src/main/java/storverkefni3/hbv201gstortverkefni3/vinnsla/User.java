package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.beans.property.*;

public class User {
    /*
    Catarina Lima worked on this class.
     */


    /*
    Getters and Setters for the main variables involved in the User Object
     */

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    private static StringProperty name = new SimpleStringProperty();

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    private static IntegerProperty age = new SimpleIntegerProperty();

    public int getHeight() {
        return height.get();
    }

    public IntegerProperty heightProperty() {
        return height;
    }

    public void setHeight(int height) {
        this.height.set(height);
    }

    private static IntegerProperty height = new SimpleIntegerProperty();

    public int getWeight() {
        return weight.get();
    }

    public IntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

    private static IntegerProperty weight = new SimpleIntegerProperty();

    public String getGoal() {
        return goal.get();
    }

    public StringProperty goalProperty() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal.set(goal);
    }

    public static StringProperty goal = new SimpleStringProperty();

    public static int getBMI() {
        return BMI.get();
    }

    public static IntegerProperty BMIProperty() {
        return BMI;
    }

    public static void setBMI(int BMI) {
        User.BMI.set(BMI);
    }

    public static IntegerProperty BMI = new SimpleIntegerProperty();



    /**
     * Calculates the BMI of the user
     * @param height
     * @param weight
     * @return the BMI value as an Integer for cleanliness
     */

    public static double calculateBMI(int height, int weight){
        double h = height/100.0;
        return weight / (h*h);
    }

    public static void main(String[] args) {
        System.out.println(BMI);

    }
}
