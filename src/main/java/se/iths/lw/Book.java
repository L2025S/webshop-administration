package se.iths.lw;

import javax.swing.*;
import java.util.Locale;

class Book extends Product {
    private String author;

    Book ( String articleNumber, String title, double price, String description, int stock, String author) {
        super(articleNumber, title, price, description, stock);
        this.author = author;
    }
    String getAuthor() {
        return author;
    }

    void setAuthor (String author) {
        this.author = author;
    }

    @Override
    String category () {
        return "Book";
    }


    void printProductInfo () {
        System.out.println("\n Article number:" + getArticleNumber() + "\n Title: " + getTitle() + "\n Price: " + getPrice() +
                "\n Description: " + getDescription()+ "\n Stock: " + getStock() + "\n Author: " + author);
    }

    @Override
    public String toCsvFormat() {
        return String.format (Locale.US, "%s, %s, %.2f, %s, %d, %s " , getArticleNumber(), getTitle(), getPrice(), getDescription(), getStock(), author);
    } // Locale.US to make sure the decimal points can be read correctly in a Swedish Operating System.

    @Override
    void addNew() {
        super.addNew();
        setAuthor(JOptionPane.showInputDialog ("Enter Author: "));
    }

}