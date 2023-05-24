package org.example;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> listOfClients;

    public Bank() {
        listOfClients = new ArrayList<>();
    }

    public void addClient(Client client) {
        listOfClients.add(client);
    }

    public void displayClients() {
        for (Client client : listOfClients) {
            System.out.printf("Imie klienta to: %s, numer konta to %s, stan konta to %.2f%n", client.getName(), client.getAccountNumber(), client.getBalance());
        }
    }
    public void removeClient(String accountNumber) {
        Client clientToRemove = getClientByAccountNumber(accountNumber);
        if (clientToRemove != null) {
            listOfClients.remove(clientToRemove);
            System.out.println("Client with account number " + accountNumber + " has been removed.");
        } else {
            System.out.println("Client with account number " + accountNumber + " not found.");
        }
    }
    public Client getClientByAccountNumber(String accountNumber) {
        for (Client client : listOfClients) {
            if (client.getAccountNumber().equals(accountNumber)) {
                return client;
            }
        }
        return null;
    }

    public void getClientCount() {
        System.out.println(listOfClients.size());
    }
    public void deposit(String accountNumber, double balance) {
        Client searchClient = null;
        for (Client client : listOfClients) {
            if (client.getAccountNumber().equals(accountNumber)) {
                searchClient = client;
                double searchBalance= client.getBalance();
                double newBalance = searchBalance + balance;
                client.setBalance(newBalance);
                System.out.println("Deposit of " + balance + " made for client with account number " + accountNumber + " new account balance is: " + newBalance);
                break;
            }}
        if (searchClient == null) {
            System.out.println("klienta nie znaleziono");
        }
    }
   public void withdraw(String accountNumber, double amount){
       Client searchClient = null;
       for (Client client : listOfClients) {
           if (client.getAccountNumber().equals(accountNumber)) {
               searchClient = client;
               double searchBalance= client.getBalance();
               double newBalance = searchBalance - amount;
               client.setBalance(newBalance);
               System.out.println("Deposit of " + amount + " withdraw from client with account number " + accountNumber + " new account balance is: " + newBalance);
               break;
           }}
       if (searchClient == null) {
           System.out.println("klienta nie znaleziono");
       }
   }
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Client giverClient = null;
        Client receiverClient = null;
        for (Client client : listOfClients) {
            if (client.getAccountNumber().equals(fromAccountNumber)) {
                giverClient = client;
                withdraw(fromAccountNumber, amount);
            }
            if (client.getAccountNumber().equals(toAccountNumber)) {
                receiverClient = client;
                double receiverClientBalance = client.getBalance();
                deposit(toAccountNumber, amount);
            }


        }
    }
}