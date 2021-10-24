package contacts;

import java.util.Scanner;

public class Client {

    public static final PhoneBook phoneBook = new PhoneBook();
    public static final Scanner scanner = new Scanner(System.in);

    public static void start() {

        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit): ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    phoneBook.addRecord();
                    break;
                case "remove":
                    phoneBook.removeRecord();
                    break;
                case "edit":
                    phoneBook.editContact();
                    break;
                case "count" :
                    phoneBook.getContactCount();
                    break;
                case "list" :
                    phoneBook.getRecords();
                    break;
                case "exit" :
                    System.exit(0);

            }
            start();
        }



    }

}
