package za.ac.cput.service;
/*
Service Test for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.repository.EmployeeAddressRepository;
import za.ac.cput.repository.IEmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {



    @Mock
    private EmployeeAddressRepository repository;
    private static EmployeeAddress employeeAddress1, employeeAddress2;
    EmployeeAddressServiceImpl employeeAddressService;

    Country countryTest = CountryFactory.build("22010","Berlin");
     City cityTest = CityFactory.build("22010","Cape Town",countryTest);
    Address addressTest = AddressFactory.build("4","Brianas Place","83","McLane",4821, cityTest);
    Address addressTest2 = AddressFactory.build("9","Livina Place","41","Deus",4421,cityTest);

    @Order(1)
    @Test
    void save() {

        employeeAddressService = new EmployeeAddressServiceImpl(repository);
        employeeAddress1 = new EmployeeAddress.Builder().StaffId("123").Address(addressTest).build();
        employeeAddress2 = new EmployeeAddress.Builder().StaffId("124").Address(addressTest2).build();
        repository.save(employeeAddress1);
        repository.save(employeeAddress2);

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNotNull(employeeAddress1.getAddress()),
                () -> assertNotNull(employeeAddress2.getAddress())
        );

        System.out.println("EmployeesAddress have been added");
    }

    @Order(2)
    @Test
    void read() {
        repository.getReferenceById(employeeAddress1.getStaffId());
        repository.getReferenceById(employeeAddress2.getStaffId());

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNotSame(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () -> assertNotEquals(employeeAddress1.getStaffId(),employeeAddress2.getStaffId())
        );

        System.out.println(employeeAddress1.toString());
        System.out.println(employeeAddress2.toString());

    }

    @Order(4)
    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }

    @Order(3)
    @Test
    void delete() {
        repository.deleteById(employeeAddress1.getStaffId());
        repository.deleteById(employeeAddress2.getStaffId());

        assertAll(
                () -> assertNotNull(employeeAddress1.getStaffId()),
                () -> assertNotNull(employeeAddress2.getStaffId()),
                () -> assertNotSame(employeeAddress1.getStaffId(),employeeAddress2.getStaffId()),
                () -> assertNotEquals(employeeAddress1.getStaffId(),employeeAddress2.getStaffId())
        );

        System.out.println("EmployeeAddress successfully deleted");
    }
}