/*
Irepo for Country
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Country;

import java.util.List;

public interface ICountryRepository extends JpaRepository<Country,String> {
    List<Country> findAll();

}
