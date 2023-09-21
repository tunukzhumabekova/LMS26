package HomeWorksLMS.LMS26.DataBase;

import HomeWorksLMS.LMS26.Model.Phone;

import java.util.List;

public class DataBase {
 private    List<Phone> phones;

    public DataBase(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "phones=" + phones +
                '}';
    }
}
