package za.ac.cput.service;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 14 June 2022
School Management
 */
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.repository.IEmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    @Mock
    private IEmployeeRepository repository;
    private static Employee employee1, employee2;
    EmployeeServiceImpl employeeService;

    Name name1 = new Name.Builder()
                .firstName("dev")
                .middleName("eloper")
                .surname("testers")
                .build();
    Name name2 = new Name.Builder()
            .firstName("peranice")
            .middleName("aluntova")
            .surname("sheiva")
            .build();

    @Order(1)
    @Test
    void save() {

        employeeService = new EmployeeServiceImpl(repository);
        employee1 = new Employee.Builder()
                .staffId("761A")
                .email("devtesters@gmail.com")
                .name(name1)
                .build();

        employee2 = new Employee.Builder()
                .staffId("564B")
                .email("perals@gmail.com")
                .name(name2)
                .build();
        repository.save(employee1);
        repository.save(employee2);

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotNull(employee1.getEmail()),
                () -> assertNotNull(employee2.getEmail()),
                () -> assertNotNull(employee1.getName()),
                () -> assertNotNull(employee2.getName())
        );

        System.out.println("Employees have been added");
    }

    @Order(2)
    @Test
    void read() {
        repository.getReferenceById(employee1.getStaffId());
        repository.getReferenceById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId())
        );

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

    }

    @Order(3)
    @Test
    void delete() {
        repository.deleteById(employee1.getStaffId());
        repository.deleteById(employee2.getStaffId());

        assertAll(
                () -> assertNotNull(employee1.getStaffId()),
                () -> assertNotNull(employee2.getStaffId()),
                () -> assertNotSame(employee1.getStaffId(),employee2.getStaffId()),
                () -> assertNotEquals(employee1.getStaffId(),employee2.getStaffId())
        );

        System.out.println("Employee successfully deleted");
    }

    @Order(4)
    @Test
    void readAll() {
        System.out.println(repository.findAll());
    }
}