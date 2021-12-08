module com.example.utilitairejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.utilitairejavafx to javafx.fxml;
    exports com.example.utilitairejavafx;
    exports com.example.utilitairejavafx.Controllers;
    opens com.example.utilitairejavafx.Controllers to javafx.fxml;
}