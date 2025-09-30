package se.iths.lw;

import javax.swing.*;
import java.util.Locale;

class Book extends Product {
    private String author;

    Book (String articleNumber, String title, double price, String description, int stock, String author) {
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


    @Override
    public String toCsvFormat() {
        return String.format (Locale.US, "%s, %s, %.2f, %s, %d, %s" , getArticleNumber(), getTitle(), getPrice(), getDescription(), getStock(), author);
    } // Locale.US to make sure the decimal points can be read correctly in a Swedish Operating System.

    @Override
    Book addNew(){
        Book book = new Book (getArticleNumber(),getTitle(), getPrice(),getDescription(),getStock(), author);
        String articleNumber = JOptionPane.showInputDialog("Enter Article Number: ");
        book.setArticleNumber(articleNumber);
        String title = JOptionPane.showInputDialog("Enter Title: ");
        book.setTitle(title);
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price: "));
        book.setPrice(price);
        String description = JOptionPane.showInputDialog("Enter Description: ");
        book.setDescription(description);
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter Stock: "));
        book.setStock(stock);
        String author = JOptionPane.showInputDialog ("Enter Author: ");
        book.setAuthor(author);
        return book;

    }


}