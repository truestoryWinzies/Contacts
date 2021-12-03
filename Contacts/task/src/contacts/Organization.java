package contacts;

public class Organization extends BaseContact {
    private String orgName;
    private String address;

    private Organization(String phoneNumber, String orgName, String address) {
        super(phoneNumber);
        this.orgName = orgName;
        this.address = address;
    }

    @Override
    public String toString() {
        return orgName;
    }

    @Override
    public void getInfo() {
        System.out.println("Organization name: " + orgName);
        System.out.println("Address: " + address);
        System.out.println("Number: " + super.getPhoneNumber());
        System.out.println("Time created: " + super.getCreated());
        System.out.println("Time last edit: " + super.getLastUpdated());
    }

    public static class OrganizationBuilder {
        private String orgName;
        private String address;
        private String phonenumber;

        OrganizationBuilder() {}

        OrganizationBuilder(Organization organization) {
            this.orgName = organization.orgName;
            this.address = organization.address;
            this.phonenumber = organization.getPhoneNumber();
        }

        OrganizationBuilder setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        OrganizationBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        OrganizationBuilder setPhoneNumber(String phoneNumber) {
            this.phonenumber = phoneNumber;
            return this;
        }

        Organization build() {
            return new Organization(phonenumber, orgName, address);
        }

    }




}
