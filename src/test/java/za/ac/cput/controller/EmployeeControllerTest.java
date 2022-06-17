package za.ac.cput.controller;
/*
Mogamad Taariq Phillips (220166153)
ADP3 - June Assessment 2022
Date: 17 June 2022
School Management
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {
    @LocalServerPort
    private int portNo;
    private String baseURL;
    private Employee employee;
    private Name name;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {
        this.name = NameFactory.build("dev", "eloper", "Tester");
        baseURL = "http://localhost:" + portNo + "/School_Management-ADP3-Group14/EmployeeAddress/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseURL + "save_employee";
        System.out.println(url);

        employee = EmployeeFactory.builder("761A", "devtesters@gmail.com", name);
        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .postForEntity(url, this.employee, Employee.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "readEmployee/" + employee.getStaffId();
        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .getForEntity(url, Employee.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }

    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "deleteEmployee/" + employee.getStaffId();
        String id = "761A";
        ResponseEntity<Void> response = testRestTemplate.exchange(url + id,
                HttpMethod.DELETE,
                null,
                Void.class);
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()),
                () -> assertNull(response.getBody())
        );

    }

    @Order(3)
    @Test
    void readAll() {
        String url = baseURL + "getAllEmployees";
        System.out.println(url);

        ResponseEntity<Employee[]> responseEntity = this.testRestTemplate
                .getForEntity(url, Employee[].class);

        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );

    }

    @Order(4)
    @Test
    void getEmployeeByEmail() {
        String email = "devtesters@gmail.com";
        String url = baseURL + "getEmployeeByEmail" + email;
        ResponseEntity<Employee> response = testRestTemplate.getForEntity(url, Employee.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );

    }
}