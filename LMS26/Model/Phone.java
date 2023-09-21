package HomeWorksLMS.LMS26.Model;

import java.util.List;

public class Phone {
    private int id;
    private String brand;
    private List<Contact> contacts;
    private static int idd=0;

    public Phone( String brand, List<Contact> contacts) {
        this.id = idd++;
        this.brand = brand;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Phone.idd = idd;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
