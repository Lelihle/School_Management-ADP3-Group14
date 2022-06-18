package za.ac.cput.factory;

/*
Factory Test for the EmployeeAddress
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date:june 2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.factory.StudentAddressFactoryTest.country;

class EmployeeAddressFactoryTest {

    public static Country countryTest = CountryFactory.build("22010","Berlin");
    public static City cityTest = CityFactory.build("22010","Cape Town",countryTest);
    public static Address addressTest = AddressFactory.build("4","Brianas Place","83","McLane",4821,cityTest);
    @Test
    void buildWorking() {

        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("1",addressTest);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    void buildNotWorking() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeAddressFactory.build(null,addressTest));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}