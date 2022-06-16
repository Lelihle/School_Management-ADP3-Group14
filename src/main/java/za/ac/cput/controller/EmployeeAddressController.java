package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.IEmployeeAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j
public class EmployeeAddressController {

    private final IEmployeeAddressService repository;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService repository) {
        this.repository = repository;
    }

    @PostMapping("save_employeeAddress")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress saveEmployeeAddress){
        log.info("Save request: {}",saveEmployeeAddress);

        try{
            EmployeeAddress newEmployeeAddress = repository.save(saveEmployeeAddress);
            return ResponseEntity.ok(newEmployeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployeeAddress/{staffID}")
    public ResponseEntity<Optional<EmployeeAddress>> read(@PathVariable String staffID){
        log.info("Read request: {}",staffID);

        try {
            Optional<EmployeeAddress> readEmployeeAddress = repository.read(staffID);
            return ResponseEntity.ok(readEmployeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteEmployeeAddress/{staffId}")
    public ResponseEntity<EmployeeAddress> delete(@PathVariable String staffId){
        log.info("Delete request: {}",staffId);

        this.repository.delete(staffId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllEmployeeAddresses")
    public ResponseEntity<List<EmployeeAddress>> readAll(){
        List<EmployeeAddress> list = this.repository.findAll();
        return ResponseEntity.ok(list);
    }


}
