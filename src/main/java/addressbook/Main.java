package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<AddressBook> bookList = new ArrayList<AddressBook>();

    public static void utilityMethod(String method) {
        System.out.println("Which address book?");
        String bookName = scanner.next();

        boolean found = false;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).name.equals(bookName)) {
                System.out.println("Address book found");
                found = true;

                switch (method) {
                    case "display-book":
                        bookList.get(i).displayAddressBook();
                        break;

                    case "add-contact":
                        System.out.println("Enter the details to add the contact to AddressBook");
                        Contact contact = new Contact();
                        bookList.get(i).add(contact);
                        break;

                    case "edit-contact":
                        bookList.get(i).editContact();
                        break;

                    case "delete-contact":
                        bookList.get(i).deleteContact();
                        break;
                }
            }
        }

        if (!found) {
            System.out.println("Enter a valid book name");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the AddressBook");

        int option;

        do {
            System.out.println("----------------------------------------");
            System.out.println("Enter 1. To display a particular AddressBook");
            System.out.println("Enter 2. To add a contact in a particular AddressBook");
            System.out.println("Enter 3. To edit a contact in a particular AddressBook");
            System.out.println("Enter 4. To delete a contact from a particular AddressBook");
            System.out.println("Enter 5. To add a new address book");
            System.out.println("Enter 0. To end");
            System.out.println("----------------------------------------");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    utilityMethod("display-book");
                    break;
                case 2:

                    utilityMethod("add-contact");
                    break;
                case 3:
                    utilityMethod("edit-contact");
                    break;

                case 4:
                    utilityMethod("delete-contact");
                    break;

                case 5:
                    System.out.println("Enter the name of the address book: ");
                    String bookName = scanner.next();
                    AddressBook addressBook = new AddressBook(bookName);
                    bookList.add(addressBook);
                    break;
                default:
                    break;

            }
        } while (option != 0);
    }
}