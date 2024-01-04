package addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AddressBookList {
    private Map<String, AddressBook> bookList;
    private Map<String, ArrayList<Contact>> contactDetailsBasedOnCity;
    private Map<String, ArrayList<Contact>> contactDetailsBasedOnState;

    public AddressBookList() {
        this.bookList = new HashMap<String, AddressBook>();
        this.contactDetailsBasedOnCity = new HashMap<>();
        this.contactDetailsBasedOnState = new HashMap<>();
    }

    public void addBook(String bookName) {
        bookList.put(bookName, new AddressBook(bookName));
    }

    public void displayBook(String bookName) {
        if (!bookList.containsKey(bookName)) {
            System.out.println("Invalid book name");
            return;
        }

        bookList.get(bookName).displayAddressBook();
    }

    public void addContactInBook(String bookName) {
        if (!bookList.containsKey(bookName)) {
            System.out.println("Invalid book name");
            return;
        }

        System.out.println("Enter the details to add the contact to AddressBook");
        Contact contact = new Contact();
        bookList.get(bookName).add(contact);

        if (contactDetailsBasedOnState.containsKey(contact.state))
            contactDetailsBasedOnState.get(contact.state).add(contact);
        else {
            ArrayList<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            contactDetailsBasedOnState.put(contact.state, contacts);
        }

        if (contactDetailsBasedOnCity.containsKey(contact.city))
            contactDetailsBasedOnCity.get(contact.city).add(contact);
        else {
            ArrayList<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            contactDetailsBasedOnCity.put(contact.city, contacts);
        }

    }

    public void editContactInBook(String bookName) {
        if (!bookList.containsKey(bookName)) {
            System.out.println("Invalid book name");
            return;
        }

        bookList.get(bookName).editContact();
    }

    public void deleteContactInBook(String bookName) {
        if (!bookList.containsKey(bookName)) {
            System.out.println("Invalid book name");
            return;
        }

        bookList.get(bookName).deleteContact();
    }

    public void searchContactBasedOnState(String state, String person) {
        boolean flag = false;
        if (contactDetailsBasedOnState.containsKey(state)) {
            for (Contact contact : contactDetailsBasedOnState.get(state)) {
                if (contact.firstName.equals(person)) {
                    contact.displayContact();
                    flag = true;
                }
            }
        }

        if (!flag)
            System.out.println("No contacts found with this " + person + " name in " + state);
    }

    public void searchContactBasedOnCity(String city, String person) {
        boolean flag = false;
        if (contactDetailsBasedOnCity.containsKey(city)) {
            for (Contact contact : contactDetailsBasedOnCity.get(city)) {
                if (contact.firstName.equals(person)) {
                    contact.displayContact();
                    flag = true;
                }
            }
        }
        if (!flag)
            System.out.println("No contacts found with this " + person + " name in " + city);
    }

    // UC9
    public void viewContactBasedOnCity(String city) {
        boolean flag = false;
        if (contactDetailsBasedOnCity.containsKey(city)) {
            for (Contact contact : contactDetailsBasedOnCity.get(city)) {
                contact.displayContact();
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No contacts found in " + city);
    }

    public void viewContactBasedOnState(String state) {
        boolean flag = false;
        if (contactDetailsBasedOnState.containsKey(state)) {
            for (Contact contact : contactDetailsBasedOnState.get(state)) {
                contact.displayContact();
                flag = true;
            }
        }

        if (!flag)
            System.out.println("No contacts found in " + state);
    }

    // UC10
    public int countBasedOnCity(String city) {
        if (contactDetailsBasedOnCity.containsKey(city)) {
            return contactDetailsBasedOnCity.get(city).size();
        }

        return 0;
    }

    public int countBasedOnState(String state) {
        if (contactDetailsBasedOnState.containsKey(state)) {
            return contactDetailsBasedOnState.get(state).size();
        }

        return 0;
    }

    // UC11
    public void sortViaPersonName(Map<String, ArrayList<Contact>> AddressBook, String nameOfAddressBook) {
        ArrayList<Contact> contacts = AddressBook.get(nameOfAddressBook);
        Comparator<Contact> firstNameComparator = Comparator.comparing(Contact::getFirstName);
        Collections.sort(contacts, firstNameComparator);

        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }

}
