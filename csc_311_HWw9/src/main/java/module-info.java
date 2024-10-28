module com.example.csc_311_hww9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.csc_311_hww9 to javafx.fxml;
    exports com.example.csc_311_hww9;
}