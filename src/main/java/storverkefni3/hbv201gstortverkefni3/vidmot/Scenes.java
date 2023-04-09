package storverkefni3.hbv201gstortverkefni3.vidmot;

public enum Scenes {
    INITIAL ("/storverkefni3/hbv201gstortverkefni3/initial-page-view.fxml"),
    WORKOUT("/storverkefni3/hbv201gstortverkefni3/workout-page-view.fxml"),

    USER("/storverkefni3/hbv201gstortverkefni3/user-page.fxml"),

    CHANGEGOALS("/storverkefni3/hbv201gstortverkefni3/change-goals-view.fxml"),

    CHANGEINFO("/storverkefni3/hbv201gstortverkefni3/change-credentials.fxml"),

    STRENGTH("/storverkefni3/hbv201gstortverkefni3/workout-strength-session.fxml"),

    CARDIOorENDURANCE("/storverkefni3/hbv201gstortverkefni3/workout-cardio-session.fxml");



    private String fileName;

    Scenes(String fileName){ this.fileName = fileName;}

    public String getFileName(){return fileName;}

}
