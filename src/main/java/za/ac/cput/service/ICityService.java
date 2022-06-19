package za.ac.cput.service;

import za.ac.cput.domain.City;

import java.util.List;

public interface ICityService extends IService<City, String>{
    void deleteById(String id);

    void delete(City city);

    List<City> findAll();

    List<City> findAllCities();
}
