package pl.mj.passstorage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.hibernate.Session;
import pl.mj.passstorage.model.ServerConnectionSetting;
import pl.mj.passstorage.service.HibernateUtil;
import pl.mj.passstorage.service.ServerConfigJsonReadFromFile;
import pl.mj.passstorage.service.ServerConfigJsonSaveToFile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassStorageController implements Initializable {

    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonSave;
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
    @FXML
    protected void onSaveButtonAction(ActionEvent event) throws IOException {
        ServerConnectionSetting serverConnectionSetting = new ServerConnectionSetting();
        serverConnectionSetting.setUrl(textUrl.getText());
        serverConnectionSetting.setPort(textPort.getText());

        ServerConfigJsonSaveToFile serverConfigJsonSaveToFile = new ServerConfigJsonSaveToFile();
        serverConfigJsonSaveToFile.saveConfiguration(serverConnectionSetting);

        buttonSave.setVisible(false);
    }

    @FXML
    protected void onURLTextFieldTyped(KeyEvent event) {
        setVisibleButtonSave();
    }

    @FXML
    protected void onPortTextFieldTyped(KeyEvent event) {
        setVisibleButtonSave();
    }

    private void setVisibleButtonSave() {
        buttonSave.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serverConnectionSetting = new ServerConfigJsonReadFromFile().getServerConnectionSetting();

        textUrl.setText(serverConnectionSetting.getUrl());
        textPort.setText(serverConnectionSetting.getPort());
    }


}