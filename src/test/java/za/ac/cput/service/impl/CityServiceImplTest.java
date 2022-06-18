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
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {
    private final Country country = CountryFactory.build("Planet", "Mars");
    private final City city = CityFactory.builder("12345", "DumpstaCity", country);
    @Autowired
    private ICityService service;

    @Order(1)//order of test done
    @Test
    void save() {
        City saved = this.service.save(this.city);
        System.out.println(saved);
        assertAll(() -> assertNotNull(saved), () -> assertEquals(this.city, saved));
    }

    @Order(2)//order of test done
    @Test
    void read() {
        Optional<City> read = this.service.read(this.city.getId());
        System.out.println(read);
        assertAll(() -> assertTrue(read.isPresent()), () -> assertEquals(this.city, read.get()));
    }

    @Order(3)//order of test done
    @Test
    void findAll() {
        List<City> cityList = this.service.findAll();
        System.out.println(cityList);
        assertEquals(1, cityList.size());
    }
    @Order(4)//order of test done
    @Test
    void delete() {
        this.service.delete(this.city);
        List<City> cityList = this.service.findAll();
        assertEquals(0, cityList.size());
    }

}