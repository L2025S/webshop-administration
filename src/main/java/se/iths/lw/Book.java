package se.iths.lw;

class Book extends Product {
    private String author;

    Book (String articleNumber, String title,String author, double price, String description, int stock) {
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
        super.toString(); // 这个多余？ 还是没有作用？
        return "Author: " + author;

    }

}
