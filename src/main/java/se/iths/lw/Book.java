package se.iths.lw;

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
    public String toString (){
        return "Book " + "articleNumber=" + getArticleNumber() + ", title=" + getTitle() + ", Author: " + author +
                ", price=" + getPrice() + ", description: " + getDescription() + ",stock: " + getStock();

    }

}
