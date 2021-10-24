package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String lastName;
    private String phoneNumber;



    private Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", " + phoneNumber;
    }

    public static class ContactBuilder {
        private String name;
        private String lastName;
        private String phoneNumber;
        ContactBuilder() {}

        ContactBuilder(Contact contact) {
            this.name = contact.name;
            this.lastName = contact.lastName;
            this.phoneNumber = contact.phoneNumber;
        }

        ContactBuilder setName(String name) {
            this.name = name;
            return this;
        }

        ContactBuilder setLastName(String lastName) {
           this.lastName = lastName;
           return this;
        }

        ContactBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            if (phoneNumber.isEmpty() || !checkPhoneValidity()) {
                this.phoneNumber = "[no number]";
            }

            return this;
        }

        private boolean checkPhoneValidity() {
            String patterns
                    = "(^\\+?\\d{1,3}[ |-]?(\\(\\+?\\d{1,3}\\))?([ |-]\\w{2,6})+)|(\\(\\+?\\d{1,3}\\)([ |-]?\\w{2,10})+)|(^\\w+)[ |-]?(\\(\\w+\\))?|(^\\+?\\(\\w+\\))";

            Pattern pattern = Pattern.compile(patterns);
            Matcher matcher = pattern.matcher(phoneNumber);
            return matcher.matches();
        }

        Contact build() {
            if (checkPhoneValidity()) {
                return new Contact(name, lastName, phoneNumber);
            } else {
                return new Contact(name,lastName, "[no number]");
            }
        }


    }

}
