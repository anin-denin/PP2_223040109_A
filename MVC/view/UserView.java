package view;

import java.util.Scanner;

public class UserView {
    private Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        System.out.print("Masukkan nama: ");
        return scanner.nextLine();
    }

    public String getUserEmail() {
        System.out.print("Masukkan email: ");
        return scanner.nextLine();
    }

    public void displayUser(String name, String email) {
        System.out.println("Data User:");
        System.out.println("Nama: " + name);
        System.out.println("Email: " + email);
    }
}
