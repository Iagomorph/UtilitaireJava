package com.example.utilitairejavafx.Controllers;

import com.example.utilitairejavafx.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.Year;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LibraryController implements Initializable {
    @FXML
    private TableColumn<Book, String> colAuteur;

    @FXML
    private TableColumn<Book, Integer> colColonne;

    @FXML
    private TableColumn<Book, Integer> colParution;

    @FXML
    private TableColumn<Book, Integer> colRangee;

    @FXML
    private TableColumn<Book, String> colResume;

    @FXML
    private TableColumn<Book, String> colTitre;

    @FXML
    private TableView<Book> tabBibliothèque;

    @FXML
    private TextField txtParution;

    @FXML
    private Button btnValider;

    @FXML
    private ImageView imgApercu;

    @FXML
    private TextField txtAuteur;

    @FXML
    private TextField txtColonne;

    @FXML
    private TextField txtCouverture;

    @FXML
    private TextField txtRange;

    @FXML
    private TextArea txtResume;

    @FXML
    private TextField txtTitre;

    @FXML
    private Label txtErrCol;

    @FXML
    private Label txtErrRan;

    @FXML
    private Label txtErrPar;

    @FXML
    private Label txtErrSupp;

    @FXML
    private Button btnSupp;

    @FXML
    private Button btnAnnuler;

    @FXML
    private Label txtErrPlace;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        AtomicBoolean errorRan = new AtomicBoolean(true);
        AtomicBoolean errorCol = new AtomicBoolean(true);
        AtomicBoolean errorPar = new AtomicBoolean(true);
        AtomicBoolean errorTit = new AtomicBoolean(true);
        AtomicBoolean errorAut = new AtomicBoolean(true);

        AtomicInteger rowNum = new AtomicInteger(-1);

        btnValider.setDisable(true);
        AtomicBoolean bool = new AtomicBoolean(false);

        txtTitre.setOnKeyTyped(Action -> {

            //Vérification qu'un titre à bien été saisi

            if (txtTitre.getText() == "") {
                errorTit.set(true);
            } else errorTit.set(false);

            //Si aucun des champs à remplir n'a d'erreur, le bouton valider devient cliquable

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }


        });

        txtAuteur.setOnKeyTyped(Action -> {

            //Vérification qu'un auteur à bien été saisi

            if (txtAuteur.getText() == "") {
                errorAut.set(true);
            } else errorAut.set(false);

            //Si aucun des champs à remplir n'a d'erreur, le bouton valider devient cliquable

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        txtRange.setOnKeyTyped(Erreur -> {

            // Vérification de la valeur de la rangée

            int range = 0;
            try {
                range = Integer.parseInt(txtRange.getText());
                bool.set(false);
            } catch (Exception e) {

                //Si la rangée n'est pas un chiffre

                txtErrRan.setText("Erreur : Veuillez saisir un chiffre");
                errorRan.set(true);
                bool.set(true);
            }
            //Si la rangée est trop grande

            if (range > 7) {
                txtErrRan.setText("Erreur : La rangée est trop grande");
                errorRan.set(true);
            }
            //Si la rangée est trop petite

            else if (range < 1) {
                txtErrRan.setText("Erreur : La rangée est trop petite");
                errorRan.set(true);
            } else {
                txtErrRan.setText("");
                errorRan.set(false);
            }
            if (bool.get()) {
                txtErrRan.setText("Erreur : Veuillez saisir un chiffre");
                errorRan.set(true);
            }
            //Si la rangée est vide
            if (txtRange.getText() == "") {
                txtErrRan.setText("");
                errorRan.set(true);
            }

            //Si aucun des champs à remplir n'a d'erreur, le bouton valider devient cliquable

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }



        });

        txtColonne.setOnKeyTyped(Erreur -> {
            int range = 0;

            //Vérification de la valeur de la colonne

            try {
                range = Integer.parseInt(txtColonne.getText());
                bool.set(false);
            } catch (Exception e) {

                //Si la valeur n'est pas un chiffre

                txtErrCol.setText("Erreur : Veuillez saisir un chiffre");
                errorCol.set(true);
                bool.set(true);
            }

            //Si la valeur est trop grande

            if (range > 7 && !Objects.equals(txtColonne.getText(), "")) {
                txtErrCol.setText("Erreur : La colonne est trop grande");
                errorCol.set(true);
            }

            //Si la valeur est trop petite

            else if (range < 1 && !Objects.equals(txtColonne.getText(), "")) {
                txtErrCol.setText("Erreur : La colonne est trop petite");
                errorCol.set(true);
            } else {
                txtErrCol.setText("");
                errorCol.set(false);
            }

            if (bool.get()) txtErrCol.setText("Veuillez saisir un chiffre");

            //Si le champs est vide

            if (txtColonne.getText() == "") {
                txtErrCol.setText("");
                errorCol.set(true);
            }

            //Si aucun des champs à remplir n'a d'erreur, le bouton valider devient cliquable

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }

        });

        txtParution.setOnKeyTyped(Erreur -> {
            int parution = 0;
            int annee = Year.now().getValue();

            //Vérification de l'année de parution

            try {
                parution = Integer.parseInt(txtParution.getText());
                bool.set(false);
            } catch (Exception e) {

                //Si la valeur n'est pas un chiffre

                txtErrPar.setText("Erreur : Veuillez saisir un chiffre");
                errorPar.set(true);
                bool.set(true);
            }

            //Si l'année est trop grande

            if (parution > annee) {
                txtErrPar.setText("Erreur : L'année de parution est dans le futur ");
                errorPar.set(true);
            } else {
                txtErrPar.setText("");
                errorPar.set(false);
            }
            if (bool.get()) {
                txtErrPar.setText("Erreur : Veuillez saisir un chiffre");
                errorPar.set(true);
            }

            //Si le champs est vide

            if (txtParution.getText() == "") {
                txtErrPar.setText("");
                errorPar.set(true);
            }

            //Si aucun des champs à remplir n'a d'erreur, le bouton valider devient cliquable

            if (errorPar.get() || errorCol.get() || errorRan.get() || errorAut.get() || errorTit.get()) {
                btnValider.setDisable(true);
            } else {
                btnValider.setDisable(false);
            }
        });

        txtCouverture.setOnKeyTyped(Url -> {

            //Afficher l'image donnée par l'url, si un url est saisi dans le champs

            String urlImg;
            urlImg = txtCouverture.getText();
            Image image = null;
            try {
                image = new Image(String.valueOf(urlImg));
            } catch (Exception ignored) {
            }

            if (Objects.equals(urlImg, "")) {
                imgApercu.setImage(null);
            } else imgApercu.setImage(image);
        });

        //Associer les valeurs correspondantes à chaque colonne du tableau

        colTitre.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuteur.setCellValueFactory(new PropertyValueFactory<>("author"));
        colParution.setCellValueFactory(new PropertyValueFactory<>("publication"));
        colColonne.setCellValueFactory(new PropertyValueFactory<>("column"));
        colRangee.setCellValueFactory(new PropertyValueFactory<>("row"));
        colResume.setCellValueFactory(new PropertyValueFactory<>("summary"));

        ObservableList<Book> bibliotheque = FXCollections.observableArrayList();

        btnValider.setOnMouseClicked(Valider -> {

            //Récuperation de ce qui a été saisi dans les champs

            String titreLivre = txtTitre.getText();
            String auteurLivre = txtAuteur.getText();
            int publicationLivre = Integer.parseInt(txtParution.getText());
            int colonneLivre = Integer.parseInt(txtColonne.getText());
            int rangeeLivre = Integer.parseInt(txtRange.getText());
            String resumeLivre = txtResume.getText();
            String urlCouvertureLivre;

            if (txtCouverture.getText() != ""){
                 urlCouvertureLivre = txtCouverture.getText();
            }else urlCouvertureLivre = "";

            System.out.println("Valider : " + rowNum.get());


            Book bookAdd = new Book(titreLivre, auteurLivre, publicationLivre, colonneLivre, rangeeLivre, resumeLivre, urlCouvertureLivre);

            boolean errPlace = false;

            //Affiche une erreur si la colonne et la rangée sont déjà occupée par un livre


            if (rowNum.get()!=-1){
                for (int i = 0; i < bibliotheque.size(); i++){
                    int indexCol = Integer.parseInt(String.valueOf(bibliotheque.get(i).getColumn()));
                    int indexRan = Integer.parseInt(String.valueOf(bibliotheque.get(i).getRow()));

                    if(colonneLivre == indexCol && rangeeLivre == indexRan){
                        if(rowNum.get() != i){
                            txtErrPlace.setText("La colonne et la rangée sont déjà occupées");
                            errPlace = true;
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < bibliotheque.size(); i++){
                    int indexCol = Integer.parseInt(String.valueOf(bibliotheque.get(i).getColumn()));
                    int indexRan = Integer.parseInt(String.valueOf(bibliotheque.get(i).getRow()));

                    if(colonneLivre == indexCol && rangeeLivre == indexRan){
                        txtErrPlace.setText("La colonne et la rangée sont déjà occupées");
                        errPlace = true;
                    }
                }
            }

            if(!errPlace){
                txtErrPlace.setText("");

                if(rowNum.get() != -1){
                    bibliotheque.set(rowNum.get(), bookAdd);
                }
                else bibliotheque.add(bookAdd);

                //Ajout au tableau le nouveau livre

                tabBibliothèque.setItems(bibliotheque);

                //Supprime le contenu des champs

                txtTitre.setText("");
                txtAuteur.setText("");
                txtParution.setText("");
                txtColonne.setText("");
                txtRange.setText("");
                txtResume.setText("");
                txtCouverture.setText("");
                imgApercu.setImage(null);


                errorCol.set(true);
                errorRan.set(true);
                errorAut.set(true);
                errorTit.set(true);
                errorPar.set(true);

                btnValider.setDisable(true);

            }
        });

        tabBibliothèque.getSelectionModel().getSelectedItems().addListener((ListChangeListener<Book>) change -> {

            rowNum.set(tabBibliothèque.getSelectionModel().getSelectedIndex());
            for (Book row: change.getList()) {
                System.out.println("Selection : " + rowNum.get());
                txtTitre.setText(row.getTitle());
                txtAuteur.setText(row.getAuthor());
                txtParution.setText(String.valueOf(row.getPublication()));
                txtColonne.setText(String.valueOf(row.getColumn()));
                txtRange.setText(String.valueOf(row.getRow()));
                txtResume.setText(String.valueOf(row.getSummary()));
                txtCouverture.setText(String.valueOf(row.getUrlCover()));
                if (txtCouverture.getText() != ""){
                    imgApercu.setImage(new Image(String.valueOf(txtCouverture.getText())));
                } else imgApercu.setImage(null);



                errorCol.set(false);
                errorRan.set(false);
                errorAut.set(false);
                errorTit.set(false);
                errorPar.set(false);




                btnValider.setDisable(false);
            }

        });

        btnSupp.setOnMouseClicked(Supprimer ->{

            txtErrSupp.setText("");

            //Suprrime la ligne selectionnée

            if(rowNum.get() != -1){
                bibliotheque.remove(rowNum.get());

                tabBibliothèque.getSelectionModel().clearSelection();
                System.out.println("Supprimer : " + rowNum.get());

                txtTitre.setText("");
                txtAuteur.setText("");
                txtParution.setText("");
                txtColonne.setText("");
                txtRange.setText("");
                txtResume.setText("");
                txtCouverture.setText("");
                imgApercu.setImage(null);

            }
            else txtErrSupp.setText("Erreur : vous n'avez selectionné aucune ligne");

            btnValider.setDisable(true);



        });

        btnAnnuler.setOnMouseClicked(Annuler ->{
            tabBibliothèque.getSelectionModel().clearSelection();
            System.out.println("Annuler : " + rowNum.get());

            txtTitre.setText("");
            txtAuteur.setText("");
            txtParution.setText("");
            txtColonne.setText("");
            txtRange.setText("");
            txtResume.setText("");
            txtCouverture.setText("");
            imgApercu.setImage(null);

            btnValider.setDisable(true);

        });
    }

}
