module com.example.stowellcop3330assignment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;


    opens com.example.stowellcop3330assignment4 to javafx.fxml;
    exports com.example.stowellcop3330assignment4;
}