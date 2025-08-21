package application;

import entities.Account;
import exceptions.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

        System.out.println("Enter account Data");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Withdrawal limit: ");
        double withdrawLimit = sc.nextDouble();
        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.print("\n" + "Enter amount to withdraw: ");
        account.withdraw(sc.nextDouble());

        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }

        finally {
            sc.close();
        }


    }
}
