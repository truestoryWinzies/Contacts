package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class BaseContact {
    private String phoneNumber;
    private String created;
    private String lastUpdated;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm");


    BaseContact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.created = LocalDateTime.now().format(formatter);
        this.lastUpdated = created;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastUpdated () {
        this.lastUpdated = LocalDateTime.now().format(formatter);;
    }

    public void getInfo() {};

    public String getCreated() {
        return created;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
