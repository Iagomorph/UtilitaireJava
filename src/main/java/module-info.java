module com.example.utilitairejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.utilitairejavafx to javafx.fxml;
    exports com.example.utilitairejavafx;
    opens com.example.utilitairejavafx.model to javafx.fxml;
    exports com.example.utilitairejavafx.model;
    opens com.example.utilitairejavafx.Controllers to javafx.fxml;
    exports com.example.utilitairejavafx.Controllers;
}