package za.ac.cput.service;

import za.ac.cput.domain.City;

import java.util.List;

public interface ICityService extends IService<City, String>{
    void deleteById(String id);
    List<City> findAll();
}
