package PhoneBook;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MainApp {
    private static Scanner input = new Scanner(System.in);
    private static final Phonebook phonebooks = new Phonebook();

    public static void main(String[] args) {
        goToMainMenu();
    }

    public static void goToMainMenu() {
        String mainMenu = """
                      ********************************
                                 MY PHONEBOOK
                      ------------------------------------
                       1 -> CREATE CONTACT
                       2 -> SEARCH CONTACT
                       3 -> EDIT CONTACT
                       4 -> TOTAL NUMBER OF CONTACTS
                       5 -> CONTACT LIST
                       6 -> DELETE CONTACT
                       7 -> EXIT
                      ********************************
                """;
        String decide = input(mainMenu);
        if (Objects.equals(decide, "")) goToMainMenu();
        switch (decide.charAt(0)) {
            case '1' -> savePhoneContact();
            case '2' -> findAndViewContact();
            case '3' -> {
                decide = input("""
                        1.  EDIT NAME
                        2.  EDIT PHONE NUMBER
                        3.  EDIT HOME ADDRESS
                        4.  EDIT OFFICE ADDRESS
                        5.  EDIT EMAIL
                        6.  Back.
                        """);
                switch (decide.charAt(0)) {
                    case '1' -> editName();
                    case '2' -> editNumber();
                    case '3' -> editHomeAddress();
                    case '4' -> editOfficeAddress();
                    case '5' -> editEmail();
                    case '6' -> goToMainMenu();
                    default -> goToMainMenu();
                }
            }
            case '4' -> countContact();
            case '5' -> displayListOfContact();
            case '6' -> deleteContact();
            case '7' -> exitApplication();
            default -> goToMainMenu();

        }
    }

    private static void countContact() {
        display(String.format("""
                You have %s contact(s) in your phonebook so far
                """, phonebooks.countContacts()));
        goToMainMenu();
    }

    private static void savePhoneContact() {
        try {
            String name = input("Name: ");
            String phoneNumber = input("Phone number: ");
            String homeAddress = input("Home Address: ");
            String officeAddress = input("Office Address: ");
            String email = input("Email account: ");
            phonebooks.addContact(name, phoneNumber, homeAddress, officeAddress, email);
            display("Contact saved");
            goToMainMenu();
        } catch (StringIndexOutOfBoundsException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    private static void findAndViewContact() {
        try {
            String name = input("Enter the contact name to search");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void displayListOfContact() {
        try {
            display(String.format("%s", phonebooks.listOfContact()));
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void editName() {
        try {
            String name = input("Enter the name of contact that you want to edit: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            String changedName = input("Edit the contact name: ");
            phonebooks.editNameOfContact(name, changedName);
            display("\nContact name successfully edited");
            phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void editNumber() {
        try {
            String name = input("Enter the name of contact that you want to edit: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            String changedNumber = input("Edit contact number: ");
            phonebooks.editNumberOfContact(name, changedNumber);
            display("\nContact phone number successfully edited");
            phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            goToMainMenu();
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void editHomeAddress() {
        try {
            String name = input("Enter the name of contact that you want to edit: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            String changedHomeAddress = input("Edit contact home address: ");
            phonebooks.editNumberOfContact(name, changedHomeAddress);
            display("\nContact home address successfully edited");
            phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void editOfficeAddress() {
        try {
            String name = input("Enter the name of contact that you want to edit: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            String changedOfficeAddress = input("Edit contact office address: ");
            phonebooks.editNumberOfContact(name, changedOfficeAddress);
            display("\nContact office address successfully edited");
            phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
    }

    public static void editEmail() {
        try {
            String name = input("Enter the name of contact that you want to edit: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            String changedEmail = input("Edit contact email: ");
            phonebooks.editNumberOfContact(name, changedEmail);
            display("\nContact phone number successfully edited");
            phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
    }

    public static void deleteContact() {
        try {
            String name = input("Enter the name of contact that you wish to delete: ");
            String phoneBook = String.format("%s ", phonebooks.findContacts(name).toString());
            display(phoneBook);
            phonebooks.deleteContact(name);
            display("\nContact successfully deleted");
            goToMainMenu();
        } catch (InputMismatchException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    private static void exitApplication() {
        display("Phonebook Application Closed...");
        System.exit(1);
    }


    //    private static String input(String prompt) {
//        display(prompt);
//        return input.nextLine();
//
//    }
//
//    private static void display(String prompt) {
//        System.out.println(prompt);
//    }
    public static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }
}

