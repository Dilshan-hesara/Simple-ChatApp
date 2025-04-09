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
import java.net.ServerSocket;
import java.net.Socket;

public class serverConrroller {

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
                ServerSocket serverSocket = new ServerSocket(4000);
                Socket socket = serverSocket.accept();

                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                txtArea.appendText("Client connected..." +"\n" );

                while (true) {
                    String msg = input.readUTF();
                  txtArea.appendText("Client: " + msg +"\n");


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ).start();
    }

    @FXML
    void sendbtnOnAction() {
        String msg = txtmsg.getText();
        try {
            output.writeUTF(msg); //send client msg
            output.flush();


            txtArea.appendText("Server: " + msg+"\n" );
            txtmsg.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
