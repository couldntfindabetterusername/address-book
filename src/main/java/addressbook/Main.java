package addressbook;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static AddressBookList bookList = new AddressBookList();

    public static void utilityMethod(String method) {
        System.out.println("Which address book?");
        String bookName = scanner.next();

        switch (method) {
            case "display-book":
                bookList.displayBook(bookName);
                break;

            case "add-contact":
                bookList.addContactInBook(bookName);
                break;

            case "edit-contact":
                bookList.editContactInBook(bookName);
                break;

            case "delete-contact":
                bookList.deleteContactInBook(bookName);
                break;
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
            System.out.println("Enter 6. To get a person from particular state");
            System.out.println("Enter 7. To get a person from particular city");
            System.out.println("Enter 8. To view contacts based on state name");
            System.out.println("Enter 9. To view contacts based on city name");
            System.out.println("Enter 10. To view the count of contacts based on state");
            System.out.println("Enter 11. To view the count of contacts based on city");
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
                    bookList.addBook(bookName);
                    break;

                case 6:
                    System.out.println("Enter the name of the state: ");
                    String state = scanner.next();
                    System.out.println("Enter the name of the person: ");
                    String personByState = scanner.next();
                    bookList.searchContactBasedOnState(state, personByState);
                    break;
                case 7:
                    System.out.println("Enter the name of the city: ");
                    String city = scanner.next();
                    System.out.println("Enter the name of the person: ");
                    String personByCity = scanner.next();
                    bookList.searchContactBasedOnCity(city, personByCity);
                case 8:
                    System.out.println("Enter the name of the state: ");
                    String stateName = scanner.next();
                    bookList.viewContactBasedOnState(stateName);
                    break;
                case 9:
                    System.out.println("Enter the name of the city: ");
                    String cityName = scanner.next();
                    bookList.viewContactBasedOnCity(cityName);
                    break;
                case 10:
                    System.out.println("Enter the name of the state: ");
                    String stateName1 = scanner.next();
                    bookList.countBasedOnState(stateName1);
                    break;
                case 11:
                    System.out.println("Enter the name of the city: ");
                    String cityName1 = scanner.next();
                    bookList.countBasedOnCity(cityName1);
                    break;
                default:
                    break;

            }
        } while (option != 0);
    }
}