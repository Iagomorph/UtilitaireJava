package com.example.utilitairejavafx.model;

import javafx.scene.image.Image;

public class Book {

    private String title;
    private String author;
    private int publication;
    private int column;
    private int row;
    private String summary;
    private String urlCover;
 //   private Image cover;

    public Book(String title, String author, int publication, int column, int row, String summary, String urlCover) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.column = column;
        this.row = row;
        this.summary = summary;
        this.urlCover = urlCover;
 //       this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrlCover() {
        return urlCover;
    }

    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover;
    }

//    public Image getCover() {
//        return cover;
//    }
//
//    public void setCover(Image cover) {
//        this.cover = cover;
//    }
}
