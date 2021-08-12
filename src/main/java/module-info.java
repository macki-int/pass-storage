module pl.mj.passstorage {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires org.json;
    requires org.junit.jupiter.api;

    opens pl.mj.passstorage to javafx.fxml;
    exports pl.mj.passstorage;
    exports pl.mj.passstorage.controller;
    opens pl.mj.passstorage.controller to javafx.fxml;
}