package logowanie;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        String Username;
        String Password;

        Password = "jd";
        Username = "kacperadamiak";

        Scanner input1 = new Scanner(System.in);
        System.out.println("Podaj swoja nazwe uzytkownika: ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Podaj swoje haslo: ");
        String password = input2.next();

        if (username.equals(Username) && password.equals(Password)) {

            System.out.println("Access Granted! Welcome!");
        }

        else if (username.equals(Username)) {
            System.out.println("Invalid Password!");
        } else if (password.equals(Password)) {
            System.out.println("Invalid Username!");
        } else {
            System.out.println("Invalid Username & Password!");
        }

    }

}