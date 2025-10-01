package se.iths.lw;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Main {
    public static void main(String[] args) throws IOException {

        Object[] functions = {"Add product", "List all products", "Show product's info.", "Exit application"};
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
                Object[] addProduct = {"Add Book", "Add Clothes", "Add Food"};
                Object selectedProduct = JOptionPane.showInputDialog(
                        null,
                        "Choose the category",
                        "Category",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        addProduct,
                        addProduct[0]
                );
                switch (selectedProduct.toString()) {
                    case "Add Book":
                        Book book = new Book("articleNumber", "title", 0.0, "description", 0, "author");
                        book.addNew();
                        book.toCsvFormat();
                        String content = book.toCsvFormat();
                        Path file = Path.of("webshop.csv");
                        try {
                            Files.writeString(file, System.lineSeparator() + content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    case "Add Clothes":
                        Clothes clothes = new Clothes("articleNumber", "title", 0.0, "description", 0, "size", "color");
                        clothes.addNew();
                        content = clothes.toCsvFormat();
                        file = Path.of("webshop.csv");
                        try {
                            Files.writeString(file, System.lineSeparator() + content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    case "Add Food":
                        Food food = new Food("articleNumber", "title", 0.0, "description", 0, LocalDate.parse("2025-10-01"));
                        food.addNew();
                        content = food.toCsvFormat();
                        file = Path.of("webshop.csv");
                        try {
                            Files.writeString(file, System.lineSeparator() + content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                }
                break;
            case "List all products":
                List<String> lines;
                lines = Files.readAllLines(Path.of("webshop.csv"));
                for (String line : lines) {
                    System.out.println(line);
                }
                break;

            case "Show product's info":
                String searchedProduct = JOptionPane.showInputDialog(
                        null,
                        "Enter the product name",
                        "Product's information",
                        JOptionPane.QUESTION_MESSAGE
                );
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("webshop.csv"));
                    String line = reader.readLine();
                    if (line.contains(searchedProduct)) {
                        System.out.println(line);
                    } else {
                        System.out.println("The product is not found.");
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Exit application":
                        System.exit(0);

        }
    }
}

