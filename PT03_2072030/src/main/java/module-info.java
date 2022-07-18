module com.example.pt03_2072030 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pt03_2072030 to javafx.fxml;
    exports com.example.pt03_2072030;
    exports com.example.pt03_2072030.Controller;
    opens com.example.pt03_2072030.Controller to javafx.fxml;
    exports com.example.pt03_2072030.Model;
    opens com.example.pt03_2072030.Model to javafx.fxml;
}