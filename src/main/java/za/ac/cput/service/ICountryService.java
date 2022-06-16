
package za.ac.cput.service;

import za.ac.cput.domain.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country,String>{
    void delete(Country country);

    List<Country> findAll();
    //void delete(String s);
    void deleteById(String id);
}
