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

        List<User> users = new ArrayList<>();
        User theOnlyUser = new User("lw2025", "java2025");
        users.add(theOnlyUser);
        boolean running = true;

        while (running) {

            login(users);

            boolean loggedIn = true;

            createFile();

            while (loggedIn) {
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
                                addBook();
                                String content;
                                Path file;
                                break;
                            case "Add Clothes":
                                addClothes();
                                break;
                            case "Add Food":
                                addFood();
                                break;
                                }
                        break;

                    case "List all products":
                        listAllProducts();
                        break;

                    case "Show product's info.":
                        showProductsInfo();
                        break;


                    case "Exit application":
                        System.out.println("Quitting the application...");
                        loggedIn = false;
                        running = false;
                        System.exit(0);
                        break;

                }
            }
        }
    }

    private static void createFile() throws IOException {
        Path file = Path.of("webshop.csv");
        if (Files.notExists(file)) {
            Files.createFile(file);
        }
    }

    private static void showProductsInfo() {
        String searchedProduct = JOptionPane.showInputDialog(
                null,
                "Enter the product name",
                "Product's information",
                JOptionPane.QUESTION_MESSAGE
        );
        try (BufferedReader reader = new BufferedReader(new FileReader("webshop.csv"))) {

            String line;

            while ((line = reader.readLine())!=null) {
                if (line.trim().toLowerCase().contains(searchedProduct.trim().toLowerCase())) {
                    System.out.println("The product's information: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listAllProducts() throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Path.of("webshop.csv"));
        if (!lines.isEmpty()) {
            for (String line : lines) {
                System.out.println(line);
            }
        } else {
            System.out.println("There is no product to show. Please add product first.");
        }
    }

    // ======================= hjälpmetoder att lägga till olika produkter =================================================
    private static void addFood() {
        Path file;
        String content;
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

    private static void addClothes() {
        String content;
        Path file;
        Clothes clothes = new Clothes("articleNumber", "title", 0.0, "description", 0, "size", "color");
        clothes.addNew();
        content = clothes.toCsvFormat();

        file = Path.of("webshop.csv");
        try {
            Files.writeString(file, System.lineSeparator() + content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addBook() {
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
    }

    //========================= hjälpmetoder att logga in=================================================================
    private static User findUser(List<User> users, String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    private static User login(List<User> users) {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter Username: ");
            String password = JOptionPane.showInputDialog("Enter Password: ");
            User currentUser = findUser(users, username, password);

            if (currentUser != null) {
                return currentUser;
            }
        System.out.println("Invalid Username or Password");
        }
    }
}

