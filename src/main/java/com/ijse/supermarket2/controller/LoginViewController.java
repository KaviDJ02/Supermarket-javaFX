package com.ijse.supermarket2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextbox;

    @FXML
    private TextField usernameTextbox;

    @FXML
    private Label errMsg;

    @FXML
    void LoginButtonOnAction(ActionEvent event) {
        String username = usernameTextbox.getText();
        String password = passwordTextbox.getText();

        if ("admin".equals(username) && "123".equals(password)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errMsg.setText("Invalid username or password");
        }
    }

}
