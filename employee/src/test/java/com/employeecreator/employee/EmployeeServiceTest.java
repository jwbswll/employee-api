package com.employeecreator.employee;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  private EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
  @Mock
  private ModelMapper mapper;
  @Autowired
  @InjectMocks
  private EmployeeService underTest;

  @Test
  void getAllShouldGetAllEmployees() {
    underTest.getAll();
    verify(repo).findAll();
  }

  @Test
  void getByIdShouldRunFindById() {
    underTest.getById(1L);
    verify(repo).findById(1L);
  }

  Date startDate = new Date();
  CreateEmployeeDTO data = new CreateEmployeeDTO("jackk", "boswell", "test1@test.com", startDate,
      "Permanent",
      "Full-time");
  Employee emp = new Employee();

  @Test
  void addShouldAddEntityToRepo() {
    when(repo.save(any())).thenReturn(emp);
    Optional<Employee> maybe = underTest.add(data);
    assertTrue(maybe.isPresent());
  }

  @Test
  void itShouldDeleteEmployeeIfIdExists() {
    Long id = 123L;

    BDDMockito.given(repo.existsById(ArgumentMatchers.anyLong())).willReturn(true);

    underTest.deleteById(id);

    ArgumentCaptor<Long> idArgument = ArgumentCaptor.forClass(Long.class);

    verify(repo).deleteById(idArgument.capture());

    assertThat(idArgument.getValue()).isEqualTo(id);
  }

}
