package se.iths.lw;

import java.util.Locale;

class Book extends Product {
    private String author;

    Book (String articleNumber, String title, String author, double price, String description, int stock) {
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
        return String.format (Locale.US, "%s, %s, %s, %.2f, %s, %d" , getArticleNumber(), getTitle(), author, getPrice(), getDescription(), getStock());
    } // Locale.US to make sure the decimal points can be read correctly in a Swedish Operating System.

}