package storverkefni3.hbv201gstortverkefni3.vidmot;

public enum View {
    /**
     * Enumeration of the different views being loaded by different fxml files to make it easier to grab and load when
     * the appropriate methods are called.
     */
    MAIN("initial-page-view.fxml"),
    WORKOUTS("workout-page-view.fxml"),

    CARDIOSESSION("workout-cardio-session.fmxl"),

    STRENGTHSESSION("workout-strength-session.fxml");

    private String fileName;

    View(String fileName){ this.fileName = fileName;}

    public String getFileName(){return fileName;}
}
