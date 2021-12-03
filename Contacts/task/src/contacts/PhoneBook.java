package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private List<BaseContact> phoneBook;
    private static final Scanner sc = new Scanner(System.in);
    private ContactFactory contactFactory;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
        this.contactFactory = new ContactFactory();
    }

    public void createRecord () {
        System.out.print("Enter the type (person, organization)");
        String type = sc.nextLine();
        BaseContact contact = contactFactory.createContact(type);

            if (contact == null) {
                System.out.println("Wrong number format!");
            } else if (phoneBook.add(contact)) {
                System.out.println("The record added.");
            }
//        }
    }

    public List<BaseContact> getPhoneBook() {
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

    public void editRecord () {
        if(phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            getRecords();

            System.out.println("Select a record: ");
            int index = sc.nextInt() - 1;

            BaseContact editableContact = phoneBook.get(index);
            BaseContact updatedContact = contactFactory.editContact(editableContact);
            phoneBook.set(index, updatedContact);

        }

    }

    public void getContactCount() {
        System.out.printf("The Phone Book has %s records.\n", phoneBook.size());
    }


    public BaseContact getContact (int contactId)  {
            BaseContact contact = phoneBook.get(contactId);
            return contact;
    }

    public void listContacts() {
        for (BaseContact contact : phoneBook) {
            System.out.println(contact.toString());
        }
    }

    public void getContactInfo() {
        getRecords();
        System.out.println("Select a record: ");
        int contactId = sc.nextInt() - 1;

        BaseContact contact = phoneBook.get(contactId);
        contact.getInfo();

    }



}
