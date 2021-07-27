package pl.mj.passstorage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PassStorageController {
    @FXML
    private Button buttonLogin;

    @FXML
    protected void onLoginButtonAction(ActionEvent event) {
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();
    }
}