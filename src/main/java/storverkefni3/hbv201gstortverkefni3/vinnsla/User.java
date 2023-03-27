package storverkefni3.hbv201gstortverkefni3.vinnsla;

public class User {
    /*
    Catarina Lima worked on this class.
     */


    /*
    Getters and Setters for the main variables involved in the User Object
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String name;

    private int age;

    private int height;

    private int weight;

    public String goal;

    public static int BMI;

    /**
     * Creates the User Object
     * @param name
     * @param age
     * @param height
     * @param weight
     * @param goal
     * Based on this, the workouts tailored to their goal will be created.
     */

    public User(String name, int age, int height, int weight, String goal){
        setName(name);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setGoal(goal);
        BMI = (int) calculateBMI(height,weight);
    }

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
        User user = new User("Cat", 23, 174, 60, "weight loss");
        System.out.println(user.age);
        System.out.println(BMI);

    }
}
