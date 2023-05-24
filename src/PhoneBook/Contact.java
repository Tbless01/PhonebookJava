package PhoneBook;

public class Contact {
    private String name;
    private String number;
    private String officeAddress;
    private String homeAddress;
    private String email;

    public Contact(String name, String number, String officeAddress, String homeAddress, String email) {
        this.name = name;
        this.number = number;
        this.officeAddress = officeAddress;
        this.homeAddress = homeAddress;
        this.email = email;
    }

    public String getContactName() {
        return name;
    }

    public void setContactName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return number;
    }

    public void setContactNumber(String number) {
        this.number = number;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("""
                 ======================
                 Name: %s
                 Phone Number: %s
                 Office Address:%s
                 Home Address:%s
                 Email:%s
                 ======================
                 """, name, number, officeAddress, homeAddress, email);
    }
}

