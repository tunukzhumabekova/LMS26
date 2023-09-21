package HomeWorksLMS.LMS26;

import HomeWorksLMS.LMS26.DataBase.DataBase;
import HomeWorksLMS.LMS26.Impl.ContactServiceImpl;
import HomeWorksLMS.LMS26.Impl.PhoneServiceImpl;
import HomeWorksLMS.LMS26.Model.Contact;
import HomeWorksLMS.LMS26.Model.Phone;
import HomeWorksLMS.LMS26.Service.ContactService;
import HomeWorksLMS.LMS26.Service.PhoneService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Contact1", 1234567890);
        Contact contact2 = new Contact("Contact2", 987-654-3210);
        List<Contact> contacts1 = new ArrayList<>();
        Arrays.asList(
                contacts1.add(contact1),
                contacts1.add(contact2)
        );
        List<Contact> contacts2 = new ArrayList<>();
        Contact contact3 = new Contact("Contact1", 123-456-7890);
        Contact contact4 = new Contact("Contact2", 987-654-3210);
        Arrays.asList(
                contacts2.add(contact3),
                contacts2.add(contact4));

        Phone phone1 = new Phone("1", contacts1);
        Phone phone2 = new Phone("1", contacts2);
        Phone phone3 = new Phone("1", contacts1);

        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);

        // Create a database instance
        DataBase database = new DataBase(phones);

        // Create instances of the services
        PhoneService phoneService = new PhoneServiceImpl(database);
        ContactService contactService = new ContactServiceImpl(database);

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Phone and Contact Management System");
            System.out.println("1. Add Phone");
            System.out.println("2. Update Phone Name");
            System.out.println("3. List All Phones");
            System.out.println("4. Find Phone by ID");
            System.out.println("5. Add Contact to Phone");
            System.out.println("6. Find Contact by Name");
            System.out.println("7. Sort Contacts by Name");
            System.out.println("8. Delete Contact by Name");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Phone
                    System.out.print("Enter Phone Name: ");
                    String phoneName = scanner.nextLine();
                    System.out.print("Enter Phone Brand: ");
                    String phoneBrand = scanner.nextLine();
                    String addPhoneResult = phoneService.addPhone(phone3);
                    System.out.println(addPhoneResult);
                    break;
                case 2:
                    // Update Phone Name
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter New Phone Name: ");
                    String newPhoneName = scanner.nextLine();
                    String updateResult = phoneService.updatePhoneNameById(phoneIdToUpdate, newPhoneName);
                    System.out.println(updateResult);
                    break;
                case 3:
                    // List All Phones
                    List<Phone> allPhones = phoneService.getAllPhones();
                    System.out.println(allPhones);
                    break;
                case 4:
                    // Find Phone by ID
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToFind = scanner.nextInt();
                    Phone foundPhone = phoneService.getPhoneById(phoneIdToFind);


                    break;
                case 5:
                    // Add Contact to Phone
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToAddContact = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Contact Name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Enter Contact Phone Number: ");
                    String contactPhoneNumber = scanner.nextLine();
                    String addContactResult = contactService.addContactToPhone(phoneIdToAddContact, contact1);
                    System.out.println(addContactResult);
                    break;
                case 6:
                    // Find Contact by Name
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToFindContactByName = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Contact Name: ");
                    String contactNameToFind = scanner.nextLine();
                    Contact foundContactByName = contactService.findContactByName(phoneIdToFindContactByName, contactNameToFind);
                    if (foundContactByName != null) {
                        System.out.println("Contact Name: " + foundContactByName.getName());
                        System.out.println("Contact Phone Number: " + foundContactByName.getPhoneNumber());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 7:
                    // Sort Contacts by Name
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToSortContacts = scanner.nextInt();
                    List<Contact> sortedContacts = contactService.sortContactsByName(phoneIdToSortContacts);
                    if (sortedContacts != null) {
                        System.out.println("Sorted Contacts by Name:");
                        for (Contact contact : sortedContacts) {
                            System.out.println("Contact Name: " + contact.getName());
                            System.out.println("Contact Phone Number: " + contact.getPhoneNumber());
                            System.out.println("------------------------");
                        }
                    } else {
                        System.out.println("Phone not found.");
                    }
                    break;
                case 8:
                    // Delete Contact by Name
                    System.out.print("Enter Phone ID: ");
                    int phoneIdToDeleteContact = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Contact Name: ");
                    String contactNameToDelete = scanner.nextLine();
                    contactService.deleteContactByNameFromPhone(phoneIdToDeleteContact, contactNameToDelete);
                    System.out.println("Contact deleted successfully.");
                    break;
                case 9:
                    // Exit
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 9);

        // Close the scanner
        scanner.close();
    }
}


