package addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    AddressBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        this.contacts.add(contact);
        System.out.println("Contact is added");
    }

    public void displayAddressBook() {
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).displayContact();
        }
    }
}
