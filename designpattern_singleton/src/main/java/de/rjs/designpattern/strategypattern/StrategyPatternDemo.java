/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.designpattern.strategypattern;

/**
 *
 * @author ralph
 */
// Strategy-Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Konkrete Strategien
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "€ mit Kreditkarte " + cardNumber + " bezahlt.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "€ mit PayPal-Account " + email + " bezahlt.");
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "€ in Bitcoin an Wallet " + walletAddress + " gesendet.");
    }
}

// Kontext-Klasse
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Setter-Injection: Strategie kann zur Laufzeit geändert werden
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Keine Zahlungsmethode gewählt!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// Demo
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Kunde möchte mit Kreditkarte bezahlen
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        cart.checkout(50);

        // Später ändert der Kunde die Zahlungsmethode zu PayPal
        cart.setPaymentStrategy(new PayPalPayment("kunde@example.com"));
        cart.checkout(75);

        // Auch Bitcoin ist möglich
        cart.setPaymentStrategy(new BitcoinPayment("1AbcWalletXYZ"));
        cart.checkout(100);
    }
}
