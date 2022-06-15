package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    public static Address address = new Address("lol");
    @Test
    void buildWorking() {

        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("1",address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    void buildNotWorking() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> EmployeeAddressFactory.build(null, address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}