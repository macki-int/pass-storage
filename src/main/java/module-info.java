module pl.mj.passstorage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens pl.mj.passstorage to javafx.fxml;
    exports pl.mj.passstorage;
    exports pl.mj.passstorage.controller;
    opens pl.mj.passstorage.controller to javafx.fxml;
}