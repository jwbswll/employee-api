package com.employeecreator.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeecreator.employee.exceptions.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private EmployeeService service;

  EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/")
  List<Employee> all() {
    return this.service.getAll();
  }

  @GetMapping("/{id}")
  ResponseEntity<Employee> findById(@PathVariable("id") Long id) throws Exception {
    Optional<Employee> maybeEmployee = this.service.getById(id);
    if (maybeEmployee.isEmpty()) {
      throw new NotFoundException("Employee with id: " + id + " not found");
    }
    return new ResponseEntity<Employee>(maybeEmployee.get(), null, HttpStatus.OK);
  }

  @PostMapping("/")
  ResponseEntity<Employee> add(@RequestBody @Valid CreateEmployeeDTO data) {
    Optional<Employee> maybeEmployee = this.service.add(data);
    if (maybeEmployee.isEmpty()) {
      return new ResponseEntity<Employee>(null, null, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<Employee>(maybeEmployee.get(), null, HttpStatus.OK);
    }
  }

  @PatchMapping("/{id}")
  ResponseEntity<Employee> updateById(@PathVariable("id") Long id, @RequestBody @Valid UpdateEmployeeDTO data) {
    Optional<Employee> maybeUpdated = this.service.updateById(id, data);
    if (maybeUpdated.isEmpty()) {
      throw new NotFoundException("Employee with id: " + id + " not found, could not update");
    }
    return new ResponseEntity<Employee>(maybeUpdated.get(), null, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
    boolean result = this.service.deleteById(id);
    if (!result) {
      return new ResponseEntity<String>("Employee with id: " + id + " does not exist, could not delete",
          HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<String>("Employee with id: " + id + " successfully deleted", HttpStatus.OK);
  }
}
