module com.ijse.supermarket2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.ijse.supermarket2.controller to javafx.fxml;
    opens com.ijse.supermarket2.dto to javafx.base; // Add this line

    exports com.ijse.supermarket2;
}