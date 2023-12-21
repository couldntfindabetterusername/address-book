package addressbook;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to address book app!");
        System.out.println("--------------------------------");

        Contact contact = new Contact("John", "Doe", "1, Azad Nagar", "New Delhi", "Delhi", "110048", "9998889992",
                "johndoe@gmail.com");
        contact.displayContact();
    }
}