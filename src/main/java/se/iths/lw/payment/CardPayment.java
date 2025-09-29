package se.iths.lw.payment;

import java.util.Scanner;

public class CardPayment implements Payment {

    @Override
    public void pay( double amount ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the card number: ");
        String cardNumber = sc.nextLine();
        System.out.println("Please enter the card holder name: ");
        String cardHolderName = sc.nextLine();
        System.out.println("Please enter Expiration Date");
        String expirationDate = sc.nextLine();
        System.out.println("Payment is being processed...");
        System.out.println("Payment completed!");

    }
}
