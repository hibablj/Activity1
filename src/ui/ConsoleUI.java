package ui;

import app.App;
import model.*;
import java.util.Scanner;

public class ConsoleUI {

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1 Add Author");
            System.out.println("2 List Authors");
            System.out.println("3 Add Paper");
            System.out.println("4 List Papers");
            System.out.println("0 Exit");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    app.authorService.save(new Author(id, name, email));
                }
                case 2 -> app.authorService.findAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Title: ");
                    String title = sc.next();
                    System.out.print("Author ID: ");
                    int aid = sc.nextInt();
                    app.paperService.save(new Paper(id, title, aid));
                }
                case 4 -> app.paperService.findAll().forEach(System.out::println);
            }
        } while (option != 0);
    }
}
