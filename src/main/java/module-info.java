module se233.casestudy1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;
    requires java.desktop;
    requires org.apache.logging.log4j;


    opens se233.casestudy1 to javafx.fxml;
    exports se233.casestudy1;
}