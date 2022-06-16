package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;

import java.util.List;

public interface ICityRepository extends JpaRepository<Country,String> {
    List<Country> findAll();

    void delete(City city);
}