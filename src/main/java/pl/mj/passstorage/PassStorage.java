package pl.mj.passstorage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PassStorage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PassStorage.class.getResource("pass-storage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Password Storage");
        Image appImageIcon = new Image("file:padlock.png");
        stage.getIcons().add(appImageIcon);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopped app");
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    public static void main(String[] args) {
        launch();
    }
}