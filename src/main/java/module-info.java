module storverkefni3.hbv201gstortverkefni3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens storverkefni3.hbv201gstortverkefni3 to javafx.fxml;
    exports storverkefni3.hbv201gstortverkefni3.vinnsla;
    exports storverkefni3.hbv201gstortverkefni3.vidmot;
    opens storverkefni3.hbv201gstortverkefni3.vidmot to javafx.fxml;
}
