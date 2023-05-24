package PhoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    private Phonebook phonebook;

    @BeforeEach
    public void setUp() {
        phonebook = new Phonebook();
        phonebook.addContact("Dupe", "08101705853", "", "", "");
    }

    @Test
    public void phoneContactsCanBeViewedTest() {
        String expected = """
                ======================
                Name: Dupe
                Phone Number: 08101705853
                Office Address:
                Home Address:
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Dupe").toString());
    }

    @Test
    public void countNumberOfContactsTest() {
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        assertEquals(2, phonebook.countContacts());
    }

    @Test
    public void TestThatContactCanBeFound() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Dupe", "08101705853", "ajewole", "wemi", "asds@gmail.com");
        String expected = """
                ======================
                Name: Dupe
                Phone Number: 08101705853
                Office Address:
                Home Address:
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Dupe").toString());
    }

    @Test
    public void TestThatContactNameCanBeEdited() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.findContacts("Prof");
        phonebook.editNameOfContact("Prof", "Miracle");
        String expected = """
                ======================
                Name: Miracle
                Phone Number: 08034234312
                Office Address:
                Home Address:
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Miracle").toString());
    }

    @Test
    public void TestThatContactNumberCanBeEdited() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.editNumberOfContact("Prof", "09076456545");
        String expected = """
                ======================
                Name: Prof
                Phone Number: 09076456545
                Office Address:
                Home Address:
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Prof").toString());
    }

    @Test
    public void TestThatContactHomeAddressCanBeEdited() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.editHomeAddressOfContact("Prof", "Boluwaduro");
        String expected = """
                ======================
                Name: Prof
                Phone Number: 08034234312
                Office Address:
                Home Address:Boluwaduro
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Prof").toString());
    }

    @Test
    public void TestThatContactOfficeAddressCanBeEdited() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.editOfficeAddressOfContact("Prof", "Sabo");
        String expected = """
                ======================
                Name: Prof
                Phone Number: 08034234312
                Office Address:Sabo
                Home Address:
                Email:
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Prof").toString());
    }

    @Test
    public void TestThatContactEmailCanBeEdited() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.editEmailOfContact("Prof", "Boluwaduro@gmail.com");
        String expected = """
                ======================
                Name: Prof
                Phone Number: 08034234312
                Office Address:
                Home Address:
                Email:Boluwaduro@gmail.com
                ======================
                """;
        assertEquals(expected, phonebook.findContacts("Prof").toString());
    }

    @Test
    public void TestThatContactCanBeCounted() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.editEmailOfContact("Prof", "Boluwaduro@gmail.com");
        assertEquals(3, phonebook.countContacts());
    }

    @Test
    public void TestThatContactCanBeDeleted() {
        phonebook.addContact("Prof", "08034234312", "", "", "");
        phonebook.addContact("Miracle", "09076456545", "ajewole", "wemi", "asds@gmail.com");
        phonebook.deleteContact("Prof");
        assertEquals(2, phonebook.countContacts());
    }
}

