package HomeWorksLMS.LMS26.Service;

import HomeWorksLMS.LMS26.Model.Phone;

import java.util.List;

public interface PhoneService {
 String addPhone(Phone phone);



        Phone getPhoneById(int phoneId);


       String updatePhoneNameById(int phoneId, String newName);


      List<Phone> getAllPhones();


       List<Phone> getAllPhonesByBrand(String brand);

      void deletePhoneById(int phoneId);
}


