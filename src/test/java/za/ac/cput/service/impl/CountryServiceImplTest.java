/*
Entity for the city
Author: Moegammad Tasreeq Adams : 216173027
Date:june 2022
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.ICountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {
    private final Country country = CountryFactory.build("12345","Mars");
    @Autowired
    private ICountryService service;

    @Order(1)//order of test done
    @Test
    void save() {Country saved = this.service.save(this.country);
        assertAll(()->assertNotNull(saved), ()->assertEquals(this.country,saved));
    }

    @Order(2)//order of test done
    @Test
    void read() {Optional<Country> read = this.service.read(this.country.getId());
        System.out.println(read);
        assertAll(()-> assertTrue(read.isPresent()), ()->assertEquals(this.country,read.get()));
    }

    @Order(4)//order of test done
    @Test void delete(){this.service.delete(this.country);
        List<Country> countryList = this.service.findAll();
        assertEquals(0, countryList.size());
    }

    @Order(3)//order of test done
    @Test
    void findAll() {
        List<Country> countryList = this.service.findAll();
        assertEquals(1,countryList.size());
    }
}