package storverkefni3.hbv201gstortverkefni3.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WorkoutName {

    public WorkoutName(String name) {
        setName(name);
    }
    public void setName(String name) {
        this.name.set(name);
    }
    private StringProperty name=new SimpleStringProperty();
    public String getName(){
        return name.get();}
    public String toString() {
        return getName(); }
}
