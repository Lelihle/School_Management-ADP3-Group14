package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.ICityRepository;
import za.ac.cput.service.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl(ICityRepository repository){
        this.repository = repository;
    }

    //(*_+)
    @Override
    public City save(City city) {
        return city;
    }

    @Override
    public Optional<City> read(String id) {
        return Optional.empty();
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }

    //(//_//)
    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }

}
