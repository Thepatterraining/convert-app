module org.thepatter.convertutil {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires hutool.all;

    opens org.thepatter.convertutil to javafx.fxml;
    exports org.thepatter.convertutil;
}