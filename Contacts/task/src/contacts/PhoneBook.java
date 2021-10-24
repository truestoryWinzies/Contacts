package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private List<Contact> phoneBook;
    private static final Scanner sc = new Scanner(System.in);

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
    }

    public void addRecord () {
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        System.out.println("Enter the surname: ");
        String surname = sc.nextLine();
        System.out.println("Enter the number: ");
        String phoneNumber = sc.nextLine();

        Contact contact = new Contact.ContactBuilder()
                .setName(name)
                .setLastName(surname)
                .setPhoneNumber(phoneNumber)
                .build();

        if (contact == null) {
            System.out.println("Wrong number format!");
        } else if (phoneBook.add(contact)) {
            System.out.println("The record added.");
        }
    }

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void getRecords () {
        for (int i = 0; i < phoneBook.size(); i++) {
            System.out.println(i + 1 + ". " + getContact(i));
        }
    }

    public void removeRecord () {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
        } else {

            listContacts();
            int index = sc.nextInt() - 1;
            if (phoneBook.size() >= index) {
                phoneBook.remove(index);
                System.out.println("The record removed!");
            } else {
                System.out.println("No such record.");
            }
        }
    }

    public void editContact () {
        if(phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            getRecords();

            System.out.println("Select a record: ");
            int index = sc.nextInt() - 1;
            sc.nextLine();

            Contact tempContact = getContact(index);
            Contact updatedContact;

            System.out.println("Select a field (name, surname, number): ");
            String field = sc.nextLine();

            String newName = "";
            String newLastName = "";
            String newPhoneNum = "";

            switch (field) {
                case "name":
                    System.out.println("Enter name: ");
                    newName = sc.nextLine();
                    updatedContact = new Contact.ContactBuilder(tempContact).setName(newName).build();
                    phoneBook.set(index, updatedContact);
                    break;
                case "surname":
                    System.out.println("Enter surname: ");
                    newLastName = sc.nextLine();
                    updatedContact = new Contact.ContactBuilder(tempContact).setLastName(newLastName).build();
                    phoneBook.set(index, updatedContact);
                    break;
                case "number":
                    System.out.println("Enter number: ");
                    newPhoneNum = sc.nextLine();
                    updatedContact = new Contact.ContactBuilder(tempContact).setPhoneNumber(newPhoneNum).build();
                    phoneBook.set(index, updatedContact);
                    break;
                default:
                    System.out.println("Incorrect field");

            }
        }



    }

    public void getContactCount() {
        System.out.printf("The Phone Book has %s records.\n", phoneBook.size());
    }


    public Contact getContact (int contactId)  {
            Contact contact = phoneBook.get(contactId);
            return contact;
    }

    public void listContacts() {
        for (Contact contact : phoneBook) {
            System.out.println(contact.toString());
        }
    }



}
