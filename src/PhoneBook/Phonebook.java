package PhoneBook;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Phonebook {
    ArrayList<Contact> contact;

    public Phonebook() {
        this.contact = new ArrayList<>();
    }

    public void addContact(String name, String number, String homeAddress, String officeAddress, String email) {
        validate(number);
        Contact newContact = new Contact(name, number, homeAddress, officeAddress, email);
        contact.add(newContact);
    }
    public static void validate(String number){
        if(number.length() < 11 || number.length()+1 > 12){
            throw new StringIndexOutOfBoundsException("Invalid number");
        }
    }

        public int countContacts () {
            return contact.size();
        }

        public Contact findContacts (String searchName){
            for (Contact contacts : contact) {
                if (contacts.getContactName().equalsIgnoreCase(searchName)) {
                    return contacts;
                }
            }
            throw new InputMismatchException("Contact name does not exist");
        }

        public ArrayList<Contact> listOfContact () {
            for (int i = 0; i < contact.size(); i++) {
                return contact;
            }
            throw new InputMismatchException("No contact found!!!");
        }

    public void editNameOfContact(String searchName, String name) {
        for (Contact contact : contact) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                contact.setContactName(name);
            }
        }
    }

    public void editNumberOfContact(String searchName, String number) {
        for (Contact contact : contact) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                contact.setContactNumber(number);
            }
        }
    }

    public void editHomeAddressOfContact(String searchName, String homeAddress) {
        for (Contact contact : contact) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                contact.setHomeAddress(homeAddress);
            }
        }
    }

    public void editOfficeAddressOfContact(String searchName, String officeAddress) {
        for (Contact contact : contact) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                contact.setOfficeAddress(officeAddress);
            }
        }
    }

    public void editEmailOfContact(String searchName, String email) {
//        validateEmail(email);
        for (Contact contact : contact) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                contact.setEmail(email);
            }
        }
    }
    public static void validateEmail(String email) {
            if (!email.endsWith("@gmail.com") || (!email.matches("@email.com"))) {
                throw new IllegalArgumentException("Invalid email");
            }
        }

    public void deleteContact(String searchName) {
        contact.removeIf(contacts -> contacts.getContactName().equalsIgnoreCase(searchName));

//        for (Contact contacts : contact) {
//            if (contacts.getContactName().equalsIgnoreCase(searchName)) {
//                contact.remove(contacts);
//            }
//        }


//}}
    }
}




