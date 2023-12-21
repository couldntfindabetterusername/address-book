package addressbook;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the AddressBook");

        // UC2
        AddressBook addressbook = new AddressBook();

        int option;

        do {
            System.out.println("----------------------------------------");
            System.out.println("Enter 1. To display the AddressBook");
            System.out.println("Enter 2. To add contact to AddressBook");
            System.out.println("Enter 3. To edit contact in AddressBook");
            System.out.println("Enter 0. To end");
            System.out.println("----------------------------------------");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addressbook.displayAddressBook();
                    break;
                case 2:
                    System.out.println("Enter the details to add the contact to AddressBook");
                    Contact contact = new Contact();
                    addressbook.add(contact);
                    break;
                case 3:
                    addressbook.editContact();
                    break;

                default:
                    break;

            }
        } while (option != 0);
    }
}