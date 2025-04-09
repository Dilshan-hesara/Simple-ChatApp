package lk.cw.simplechatapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent clientRoot = FXMLLoader.load(App.class.getResource("/view/client.fxml"));
        Stage clientStage = new Stage();
        clientStage.setScene(new Scene(clientRoot));
        clientStage.setTitle("Client");
        clientStage.setResizable(false);
        clientStage.show();

        Parent serverRoot = FXMLLoader.load(App.class.getResource("/view/server.fxml"));
        Stage serverStage = new Stage();
        serverStage.setScene(new Scene(serverRoot));
        serverStage.setTitle("Server");
        serverStage.setResizable(false);
        serverStage.show();

    }


}
