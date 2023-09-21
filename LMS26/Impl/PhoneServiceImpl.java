package HomeWorksLMS.LMS26.Impl;

import HomeWorksLMS.LMS26.DataBase.DataBase;
import HomeWorksLMS.LMS26.Model.Phone;
import HomeWorksLMS.LMS26.Service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
   private DataBase dataBase;

    public PhoneServiceImpl(DataBase database) {
    }


    @Override
    public String addPhone(Phone phone) {
        dataBase.getPhones().add(phone);
        return null;
    }

    @Override
    public Phone getPhoneById(int phoneId) {
         return dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String updatePhoneNameById(int phoneId, String newName) {
        for (int i = 0; i < dataBase.getPhones().size(); i++) {


            Phone phone = getPhoneById(phoneId);
            if (phone != null) {
                phone.getContacts().get(i).setName(newName);
                return "Phone name updated successfully";
            } else {
                return "Phone not found";
            }
        }
        return newName;
    }

    @Override
    public List<Phone> getAllPhones() {
        return dataBase.getPhones();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return dataBase.getPhones().stream()
                .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePhoneById(int phoneId) {
        dataBase.getPhones().removeIf(phone -> phone.getId() == phoneId);

    }
}
