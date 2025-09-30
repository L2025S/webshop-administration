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
    } // IntelliJ use dot as decimal point , not a comma. I write my code no IntelliJ and my computer use Swedish math system.

}