package lk.cw.simplechatapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/client.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Client");
        stage.setResizable(false);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }

}
