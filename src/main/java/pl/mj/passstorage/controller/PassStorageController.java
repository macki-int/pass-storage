package pl.mj.passstorage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.mj.passstorage.model.ServerConnectionSetting;
import pl.mj.passstorage.service.ServerConfigJsonReadFromFile;

import java.net.URL;
import java.util.ResourceBundle;

public class PassStorageController  implements  Initializable{

    @FXML
    private Button buttonLogin;
    @FXML
    private TextField textUrl;
    @FXML
    private TextField textPort;
    ServerConnectionSetting serverConnectionSetting;

    @FXML
    protected void onLoginButtonAction(ActionEvent event) {
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        serverConnectionSetting = new ServerConfigJsonReadFromFile().getServerConnectionSetting();

        textUrl.setText(serverConnectionSetting.getUrl());
        textPort.setText(serverConnectionSetting.getPort());
    }


}