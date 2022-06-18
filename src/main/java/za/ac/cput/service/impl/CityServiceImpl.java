package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.ICityRepository;
import za.ac.cput.service.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    private final ICityRepository repository;
    private CityServiceImpl ICityRepository;

    @Autowired
    public CityServiceImpl(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public Optional<City> read(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }
    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<City> findAllCities(){
        return this.ICityRepository.findAll();
    }
    public Optional<City> findCityByCountryID(String countryID){
        return this.ICityRepository.findCityByCountryID(countryID);
    }

}
