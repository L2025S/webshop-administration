package se.iths.lw;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {

        Object [] functions = { "Add product", "List all products", "Show product's info.", "Exit application"};
        Object selectedFunction = JOptionPane.showInputDialog(
                null,
                "Choose the function",
                "Functions",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                functions,
                functions[0]
        );
        switch (selectedFunction.toString()) {
            case "Add product":
                Object [] addProduct = {"Add Book", "Add Clothes", "Add Food"};
                Object selectedProduct =JOptionPane.showInputDialog (
                        null,
                        "Choose the category",
                        "Category",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        addProduct,
                        addProduct[0]
                );
                switch(selectedProduct.toString()){
                    case"Add Book":
                        Book book = new Book ("articleNumber", "title", 0.0, "description", 0, "author");
                        book.addNew();
                        book.toCsvFormat();
                        String content = book.toCsvFormat();
                        Path file = Path.of ("webshop.csv");
                        try {
                            Files.writeString(file, System.lineSeparator() + content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    case "Add Clothes":
                        Clothes clothes = new Clothes ("articleNumber", "title",0.0, "description", 0, "size", "color");
                        clothes.addNew();
                        content = clothes.toCsvFormat();
                        file = Path.of ("webshop.csv");
                        try {
                            Files.writeString(file, System.lineSeparator()+ content, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                        } catch(IOException e) {
                            System.out.println(e.getMessage());
                        }
                    case "Add Food":
                        Food food = new Food ("articleNumber", "title", 0.0, "description", 0, LocalDate.parse ("2025-10-01"));
                        food.addNew();
                        content = food.toCsvFormat();
                        file = Path.of("webshop.csv");
                        try {
                            Files.writeString(file,System.lineSeparator()+content, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                }
            break;
            case "List all products":
                break;
            case "Show product's info":
                break;
            case "Exit application":
                System.exit(0);





        }

    }
}
