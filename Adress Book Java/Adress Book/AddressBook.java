import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return "Name: " + firstName + ", Last name: " + lastName +
               ", Phone number: " + phoneNumber + ", E-mail: " + email;
    }
}

public class AddressBook {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public AddressBook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        
        contacts.add(new Contact(firstName, lastName, phoneNumber, email));
        System.out.println("Contact saved!\n");
    }

    // Viev Contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts saved.");
        } else {
            System.out.println("Contact list:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
        System.out.println();
    }

    // Remove Contacts
    public void removeContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete.\n");
            return;
        }

        System.out.print("Enter the number of the contact to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1; // Зміщення на -1 для індексації
            if (index >= 0 && index < contacts.size()) {
                contacts.remove(index);
                System.out.println("Contact has been deleted.\n");
            } else {
                System.out.println("Invalid contact number.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.\n");
        }
    }

    // Choice
    public void start() {
        String input;
        int choice;
        
        do {
            System.out.println("Address Book:");
            System.out.println("1. Add new contact");
            System.out.println("2. Show contacts");
            System.out.println("3. Delete contact");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) {
                    System.out.println("Please choose a valid option (1-4).\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number (1-4).\n");
                continue;
            }

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> removeContact();
                case 4 -> System.out.println("Exiting address book.");
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (!input.equals("4"));
    }

    // Start
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.start();
    }
}