package lk.cw.simplechatapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class clientConrroller {


    @FXML
    private Button sendbtn;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtmsg;

    private DataInputStream input;
    private DataOutputStream output;

    public void initialize() {

        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 4000);
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String msg = input.readUTF();
                    Platform.runLater(() -> txtArea.appendText("Server : "+ msg + "\n"));

                    if (msg.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void sendbtnOnAction() {
        String msg = txtmsg.getText();
        try {
            output.writeUTF(msg);
            output.flush();
            txtArea.appendText("Client: " + msg + "\n");
            txtmsg.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
