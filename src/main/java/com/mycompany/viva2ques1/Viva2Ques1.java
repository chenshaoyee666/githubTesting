/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.viva2ques1;

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Viva2Ques1 {
    //enforce encapsulation, ensuring that they cannot be directly accessed or modified from outside the class.
        private static double balance = 1000.0;
        private static ArrayList<String>transactionHistory = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the Bank");
       do{
        System.out.println("""
        1. Check Balance
        2. Deposit Money
        3. Withdraw Money
        4. View Transaction History
        5. Exit                   """);
        System.out.print("Choose an option: ");
        choice =sc.nextInt();
        
        switch (choice){
            case 1:
                checkBalance();
                System.out.println();
                break;
            case 2:
                System.out.print("Enter amount to deposit: RM");
                double depositNum = sc.nextDouble();
                deposit(depositNum);
                System.out.println();
                break;
            case 3:
                System.out.print("Enter amount to withdraw: RM");
                double withdrawalNum = sc.nextDouble();
                withdraw(withdrawalNum);
                System.out.println();
                break;
            case 4:
                printTransactions();
                System.out.println();
                break;
            case 5:
                System.out.println();
                System.out.println("Thank you for using our banking system!");
                System.out.printf("Your final balance is: RM%.2f", balance);
                System.out.println();
                return;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    } while(choice !=5);
    }

    /*constructor is a special method that initializes an object when it is created.
    same name as the class and no return type.
    public so that class can be created from outside the class:
    
    public bankSystem(){
        this.balance = 1000;
        this.transactionHistory;
        */
    public static void checkBalance() {
        System.out.printf("Current balance: RM%.2f%n",balance); 
    }
    
    public static void deposit(double amount){
        if(amount>0){
            balance+=amount;
            transactionHistory.add("Deposited: RM" + String.format("%.2f",amount));
            System.out.printf("Your balance is now: RM%.2f%n",balance);
        }else{
            System.out.println("Invalid deposit");
        }
    }
    
    public static void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            transactionHistory.add("Withdrew: RM" + String.format("%.2f",amount));
            System.out.printf("Your balance is now: RM%.2f%n",balance);
        }else if(amount>balance){
            System.out.println("Insufficient balance");    
        }else{
            System.out.println("Invalid withdraw");
        }
    }
    
    public static void printTransactions(){
        if(transactionHistory.isEmpty()){
            System.out.println("No transactions");
        }else{
            System.out.println("Transaction History:");
            for(String value : transactionHistory){
                System.out.println(value);
            }
        }
    }
}