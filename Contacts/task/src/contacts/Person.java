package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends BaseContact {
    private String name;
    private String lastName;
    private String birth;
    private String gender;



    private Person(String name, String lastName, String phoneNumber, String birth, String gender) {
        super(phoneNumber);
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    @Override
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + lastName);
        System.out.println("Birth date: " + birth);
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + super.getPhoneNumber());
        System.out.println("Time created: " + super.getCreated());
        System.out.println("Time last edit: " + super.getLastUpdated());
    }



    public static class PersonBuilder {
        private String name;
        private String lastName;
        private String phoneNumber;
        private String birth;
        private String gender;

        PersonBuilder() {}

        PersonBuilder(Person person) {
            this.name = person.name;
            this.lastName = person.lastName;
            this.phoneNumber = person.getPhoneNumber();
            this.birth = person.birth;
            this.gender = person.gender;
            person.setLastUpdated();

        }

        PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        PersonBuilder setLastName(String lastName) {
           this.lastName = lastName;
           return this;
        }

        PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
//            if (phoneNumber.isEmpty() || !checkPhoneValidity()) {
//                this.phoneNumber = "[no number]";
//            }

            return this;
        }

        PersonBuilder setBirth(String birth) {
//            if (birth.isEmpty()){
//                this.birth = "[no data]";
//                return this;
//            }
            this.birth = birth;
            return this;
        }

        PersonBuilder setGender(String gender) {
            if (gender.equals("M") || gender.equals("F")) {
                this.gender = gender;
                return this;
            }

            System.out.println("HELLO");
            this.gender = "[no data]";
            return this;
        }

        private boolean checkPhoneValidity() {
            String patterns
                    = "(^\\+?\\d{1,3}[ |-]?(\\(\\+?\\d{1,3}\\))?([ |-]\\w{2,6})+)|(\\(\\+?\\d{1,3}\\)([ |-]?\\w{2,10})+)|(^\\w+)[ |-]?(\\(\\w+\\))?|(^\\+?\\(\\w+\\))";

            Pattern pattern = Pattern.compile(patterns);
            Matcher matcher = pattern.matcher(phoneNumber);
            return matcher.matches();
        }


        Person build() {
            if (checkPhoneValidity()) {
                return new Person(name, lastName, phoneNumber, birth, gender);
            } else {
                return new Person(name,lastName, "[no number]", birth, gender);
            }
        }


    }

}
