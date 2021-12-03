package contacts;

import java.util.Scanner;

public class ContactFactory {
    private static final Scanner sc = new Scanner(System.in);

    BaseContact createContact(String type) {
        type = type.toLowerCase();
        if(type.equals("person")) {
            System.out.print("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the surname: ");
            String surname = sc.nextLine();

            System.out.print("Enter the birth date: ");
            String birth = sc.nextLine();
            if (birth.isEmpty()) {
                System.out.println("Bad birth date!");
                birth = "[no data]";
            }

            System.out.print("Enter the gender (M, F): ");
            String gender = sc.nextLine();
            if (!gender.equals("M") || !gender.equals("F")){
                System.out.println("Bad gender!");
                gender = "[no data]";
            }

            System.out.print("Enter the number: ");
            String phoneNumber = sc.nextLine();

            BaseContact person = new Person.PersonBuilder()
                    .setName(name)
                    .setLastName(surname)
                    .setPhoneNumber(phoneNumber)
                    .setBirth(birth)
                    .setGender(gender)
                    .build();

            return person;
        } else if (type.equals("organization")) {
            System.out.println("Enter the organization name: ");
            String orgName = sc.nextLine();
            System.out.println("Enter the address: ");
            String address = sc.nextLine();
            System.out.println("Enter the number: ");
            String phoneNumber = sc.nextLine();

            BaseContact organization = new Organization.OrganizationBuilder()
                    .setOrgName(orgName)
                    .setAddress(address)
                    .setPhoneNumber(phoneNumber)
                    .build();

            return organization;
        }
        return null;
    }


    public BaseContact editContact(BaseContact editableContact) {
            String newName = "";
            String newLastName = "";
            String newPhoneNum = "";
            if (editableContact instanceof Person) {
                Person oldPerson = (Person) editableContact;
                System.out.println("Select a field (name, surname, birth, gender, number): ");
                String field = sc.nextLine();
                switch (field) {
                    case "name":
                        System.out.println("Enter name: ");
                        newName = sc.nextLine();
                        return new Person.PersonBuilder(oldPerson).setName(newName).build();
                    case "surname":
                        System.out.println("Enter surname: ");
                        newLastName = sc.nextLine();
                        return new Person.PersonBuilder(oldPerson).setLastName(newLastName).build();
                    case "number":
                        System.out.println("Enter number: ");
                        newPhoneNum = sc.nextLine();
                        return new Person.PersonBuilder(oldPerson).setPhoneNumber(newPhoneNum).build();
                    case "gender":
                        System.out.println("Enter gender: ");
                        String newGender = sc.nextLine();
                        return new Person.PersonBuilder(oldPerson).setGender(newGender).build();
                    case "birth":
                        System.out.println("Enter birth: ");
                        String newBirth = sc.nextLine();
                        return new Person.PersonBuilder(oldPerson).setBirth(newBirth).build();


                    default:
                        System.out.println("Incorrect field");
                        return null;

                }
            } else if (editableContact instanceof Organization) {
                Organization oldOrganization = (Organization) editableContact;
                System.out.println("Select a field (name, address, number): ");
                String field = sc.nextLine();
                switch (field) {
                    case "name":
                        System.out.println("Enter organization name: ");
                        newName = sc.nextLine();
                        return new Organization.OrganizationBuilder(oldOrganization).setOrgName(newName).build();
                    case "address":
                        System.out.println("Enter address: ");
                        String newAddress = sc.nextLine();
                        return new Organization.OrganizationBuilder(oldOrganization).setAddress(newAddress).build();
                    case "number":
                        System.out.println("Enter number: ");
                        newPhoneNum = sc.nextLine();
                        return new Organization.OrganizationBuilder(oldOrganization).setPhoneNumber(newPhoneNum).build();
                }
            }
            return null;
    }
}
