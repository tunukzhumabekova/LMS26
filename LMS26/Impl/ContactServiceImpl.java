package HomeWorksLMS.LMS26.Impl;

import HomeWorksLMS.LMS26.DataBase.DataBase;
import HomeWorksLMS.LMS26.Model.Contact;
import HomeWorksLMS.LMS26.Model.Phone;
import HomeWorksLMS.LMS26.Service.ContactService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    private DataBase database;

    public ContactServiceImpl(DataBase database) {
        this.database = database;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        Optional<Phone> optionalPhone = Optional.ofNullable(getPhoneById(phoneId));
        if (optionalPhone.isPresent()) {
            optionalPhone.get().getContacts().add(contact);
            return "Contact added successfully to phone with ID " + phoneId;
        } else {
            return "Phone not found";
        }
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        Optional<Phone> optionalPhone = Optional.ofNullable(getPhoneById(phoneId));
        if (optionalPhone.isPresent()) {
            return optionalPhone.get().getContacts().stream()
                    .filter(contact -> contact.getName().equalsIgnoreCase(contactName))
                    .findFirst()
                    .orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        Optional<Phone> optionalPhone = Optional.ofNullable(getPhoneById(phoneId));
        if (optionalPhone.isPresent()) {
            return optionalPhone.get().getContacts().stream()
                    .filter(contact -> contact.getPhoneNumber()==phoneId)
                    .findFirst()
                    .orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        Optional<Phone> optionalPhone = Optional.ofNullable(getPhoneById(phoneId));
        if (optionalPhone.isPresent()) {
            return optionalPhone.get().getContacts().stream()
                    .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Optional<Phone> optionalPhone = Optional.ofNullable(getPhoneById(phoneId));
        if (optionalPhone.isPresent()) {
            optionalPhone.get().getContacts().removeIf(contact -> contact.getName().equalsIgnoreCase(contactName));
        }
    }

    // Helper method to retrieve a Phone by ID
    private Phone getPhoneById(int phoneId) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst()
                .orElse(null);
    }
}
