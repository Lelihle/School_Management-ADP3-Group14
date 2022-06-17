package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("School_Management-ADP3-Group14/employee/")
@Slf4j
public class EmployeeController {

    private final IEmployeeService repository;

    @Autowired
    EmployeeController(IEmployeeService repository) {
        this.repository = repository;
    }

    @PostMapping("save_employee")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee saveEmployee){
        log.info("Save request: {}",saveEmployee);

        try{
            Employee newEmployee = repository.save(saveEmployee);
            return ResponseEntity.ok(newEmployee);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployee/{employeeID}")
    public ResponseEntity<Optional<Employee>> read(@PathVariable String employeeID){
        log.info("Read request: {}",employeeID);

        try {
            Optional<Employee> readEmployee = repository.read(employeeID);
            return ResponseEntity.ok(readEmployee);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteEmployee/{employeeID}")
    public ResponseEntity<Employee> delete(@PathVariable String employeeID){
        log.info("Delete request: {}",employeeID);

        this.repository.delete(employeeID);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllEmployees")
    public ResponseEntity<List<Employee>> readAll(){
        List<Employee> list = this.repository.readAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("readEmployeeByEmail/{employeeEmail}")
    public ResponseEntity<Optional<Employee>> getEmployeeByEmail(@RequestParam String email) {
        log.info("readEmployeeByEmail request: {}", email);

        try {
            Optional<Employee> readEmployeeByEmail = repository.findEmployeeByEmail(email);
            return ResponseEntity.ok(readEmployeeByEmail);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
