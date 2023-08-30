package com.employeecreator.employee;

import static org.mockito.Mockito.verify;

// import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.modelmapper.ModelMapper;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
  @Mock
  private EmployeeRepository repo;
  private EmployeeService underTest;
  // private ModelMapper mapper;

  @BeforeEach
  void setUp() {
    // String firstName = "Jack";
    // String lastName = "boswell";
    // String email = "test@test.com";
    // Date startDate = new Date(2023090909);
    // String contractType = "Permanent";
    // String contract = "Full-time";
    // Long mobile = 61433804585L;
    // String address = "1 Sydney Road, Melbourne 3000";
    // Date endDate = new Date(2024090909);
    // byte hours = 40;
    this.underTest = new EmployeeService(repo);
    // this.underTest.add(new CreateEmployeeDTO(firstName, lastName, email, mobile,
    // address, startDate, endDate,
    // contractType, contract, hours));

  }

  @Test
  void getAllShouldGetAllEmployees() {
    List<Employee> list = underTest.getAll();
    list.forEach((employee) -> System.out.println(employee.toString()));
    verify(repo).findAll();
  }

  @Test
  void getByIdShouldRunFindById() {
    underTest.getById(1L);
    verify(repo).findById(1L);
  }

}
