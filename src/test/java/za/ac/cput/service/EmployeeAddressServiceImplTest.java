package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.repository.EmployeeAddressRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {

    @Mock
    private EmployeeAddressRepository repository;
    private static EmployeeAddress empAdd1, empAdd2;
    EmployeeAddressServiceImpl employeeAddressService;

    Address address = new Address();
    Address address2 = new Address();

    @Order(4)
    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }

    @Order(1)
    @Test
    void save() {

        employeeAddressService = new EmployeeAddressServiceImpl(repository);
        empAdd1 = new EmployeeAddress.Builder().StaffId("123",address).build();
        empAdd2 = new EmployeeAddress.Builder().StaffId("321",address2).build();
        repository.save(empAdd1);
        repository.save(empAdd2);

        assertAll(
                ()-> assertNotNull(empAdd1.getStaffId()),
                ()-> assertNotNull(empAdd2.getStaffId()),
                ()-> assertNotNull(empAdd1.getAddress()),
                ()-> assertNotNull(empAdd2.getAddress())
        );
        System.out.println("EmpAddress have been added");
    }

    @Order(2)
    @Test
    void read() {
        repository.getReferenceById(empAdd1.getStaffId());
        repository.getReferenceById(empAdd2.getStaffId());

        assertAll(
                ()-> assertNotNull(empAdd1.getStaffId()),
                ()-> assertNotNull(empAdd2.getStaffId()),
                ()-> assertNotSame(empAdd1.getStaffId(),empAdd2.getStaffId()),
                ()-> assertNotEquals(empAdd1.getStaffId(),empAdd2.getStaffId())
        );

        System.out.println(empAdd1.toString());
        System.out.println(empAdd2.toString());
    }

    @Order(3)
    @Test
    void delete() {
        repository.deleteById(empAdd1.getStaffId());
        repository.deleteById(empAdd2.getStaffId());

        assertAll(
                ()-> assertNotNull(empAdd1.getStaffId()),
                ()-> assertNotNull(empAdd2.getStaffId()),
                ()-> assertNotSame(empAdd1.getStaffId(),empAdd2.getStaffId()),
                ()-> assertNotEquals(empAdd1.getStaffId(),empAdd2.getStaffId())
        );

        System.out.println("Entity Successfully Deleted.");
    }
}