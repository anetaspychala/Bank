package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       Bank a = new Bank();
       Client firstClient = new Client("Anna", "11100", 1.1);
       Client secondClient = new Client("Michal", "88880", 1203.4);
       Client thirdClient = new Client("Wojtek", "96630", 7568.9);
       a.addClient(firstClient); a.addClient(secondClient); a.addClient(thirdClient);

        System.out.println("..................usuniecie klienta..................................");
        a.removeClient("11100");

        System.out.println("..................wyszukanie klienta..................................");
        Client foundClient = a.getClientByAccountNumber("96630");
        if(foundClient!=null){
            System.out.printf("Klient ktory nazywa sie %s, ma numer konta %s stan konta %f.2%n", foundClient.getName(), foundClient.getAccountNumber(), foundClient.getBalance());
        }else{
            System.out.println("Nie znaleziono klienta");}

        System.out.println("..................tranzakcje klientow.................................");
       a.deposit("96630", 10000.2);
       a.withdraw("96630", 5000);
       a.transfer("96630", "11100", 1000);

       System.out.println("...........................Lista klientow banku.......................");
       a.displayClients();
        }
    }


