package com.employeecreator.employee;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private EmployeeRepository repo;

  @Autowired
  private ModelMapper mapper;

  EmployeeService(EmployeeRepository repo) {
    this.repo = repo;
  }

  public List<Employee> getAll() {
    return this.repo.findAll();
  }

  public Optional<Employee> getById(Long id) {
    return this.repo.findById(id);
  }

  public Optional<Employee> add(CreateEmployeeDTO data) {
    Employee employee = mapper.map(data, Employee.class);
    Optional<Employee> result = Optional.ofNullable(this.repo.save(employee));
    return result;
  }

  public Optional<Employee> updateById(Long id, UpdateEmployeeDTO data) {
    Optional<Employee> maybeEmployee = this.repo.findById(id);
    if (maybeEmployee.isPresent()) {
      Employee toUpdate = maybeEmployee.get();
      mapper.map(data, toUpdate);
      return Optional.of(this.repo.save(toUpdate));
    }
    return maybeEmployee;
  }

  public boolean deleteById(Long id) {
    Optional<Employee> maybeEmployee = this.repo.findById(id);
    if (maybeEmployee.isEmpty()) {
      return false;
    } else {
      this.repo.deleteById(id);
      return true;
    }
  }

}
