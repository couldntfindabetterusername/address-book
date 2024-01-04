package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private static Scanner scanner = new Scanner(System.in);

    public String name;
    private ArrayList<Contact> contactList;

    AddressBook(String name) {
        this.name = name;
        this.contactList = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        boolean isDuplicate = this.contactList.stream().anyMatch(c -> c.equals(contact));

        if (isDuplicate) {
            System.out.println("Contact with same name already exists");
            return;
        }

        this.contactList.add(contact);
        System.out.println("Contact is added");
    }

    public void displayAddressBook() {
        if (contactList.size() == 0) {
            System.out.println("There are no contacts in the AddressBook");
            return;
        }

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("Contact " + i + ": ");
            contactList.get(i).displayContact();
        }
    }

    public void editContact() {
        System.out.println("Enter the details of contact you want to edit");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        boolean contactFound = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstName.equals(firstName) && contactList.get(i).lastName.equals(lastName)) {
                System.out.println("Contact found");
                System.out.println("Now, enter new details");

                contactList.get(i).edit();
                System.out.println("Contact is edited");

                contactFound = true;
                return;
            }
        }

        if (!contactFound)
            System.out.println("There is no such contact with that name!");
    }

    public void deleteContact() {
        System.out.println("Enter the details of contact you want to edit");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        boolean contactFound = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstName.equals(firstName) && contactList.get(i).lastName.equals(lastName)) {
                System.out.println("Contact found");

                contactList.remove(i);
                System.out.println("Contact is deleted");

                contactFound = true;
                return;
            }
        }

        if (!contactFound)
            System.out.println("There is no such contact with that name!");
    }

}
