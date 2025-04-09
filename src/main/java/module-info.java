module lk.cw.simplechatapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.cw.simplechatapp.controller to javafx.fxml;
    exports lk.cw.simplechatapp;
    opens lk.cw.simplechatapp to javafx.base;
}