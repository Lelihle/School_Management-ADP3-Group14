package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.StudentAddressFactory;
import za.ac.cput.service.IStudentAddressService;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressServiceImplTest {

    Country country = CountryFactory.build("20111", "South African");
    City city = CityFactory.build("10111", "Saldanha", country);
    Address address = AddressFactory.build("12", "seacrest", "104", "Flurry", 7395, city);
    StudentAddress studentAddress = StudentAddressFactory.build("216118395", address);
    @Autowired
    private IStudentAddressService service;


    @Test
    @Order(1)
    void save() {
        StudentAddress saved = this.service.save(this.studentAddress);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.studentAddress, saved)
        );
    }


    @Test
    @Order(2)
    void read() {
        Optional<StudentAddress> read = this.service.read(this.studentAddress.getStudentId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get()));
    }

    @Test
    @Order(3)
    void delete() {
        this.service.delete(this.studentAddress);
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(0, studentAddressList.size());

    }


    @Test
    @Order(4)
    void findAll() {
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(1, studentAddressList.size());
    }
}