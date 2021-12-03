package contacts;

import java.util.Scanner;

public class Client {

    public static final PhoneBook phoneBook = new PhoneBook();
    public static final Scanner scanner = new Scanner(System.in);

    public static void start() {

        while (true) {
            System.out.println();
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    phoneBook.createRecord();
                    break;
                case "remove":
                    phoneBook.removeRecord();
                    break;
                case "edit":
                    phoneBook.editRecord();
                    break;
                case "count" :
                    phoneBook.getContactCount();
                    break;
                case "info" :
                    phoneBook.getContactInfo();
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
