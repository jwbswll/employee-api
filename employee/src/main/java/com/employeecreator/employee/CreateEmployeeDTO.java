package com.employeecreator.employee;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateEmployeeDTO {
  @NotNull
  public String firstName;
  @NotNull
  public String lastName;
  @NotBlank
  @Email(message = "must be email")
  public String email;
  @Nullable
  public Long mobile;
  @Nullable
  public String address;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  public Date startDate;
  @Nullable
  public Date endDate;
  @NotNull
  public String contractType;
  @NotNull
  public String contract;
  @Nullable
  public byte hours;

  CreateEmployeeDTO(String firstName, String lastName, String email, Date startDate, String contractType,
      String contract) {
  }

  @Override
  public String toString() {
    return this.firstName + this.lastName + this.email + this.startDate + this.contractType + this.contract;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getMobile() {
    return this.mobile;
  }

  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getContractType() {
    return this.contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public String getContract() {
    return this.contract;
  }

  public void setContract(String contract) {
    this.contract = contract;
  }

  public byte getHours() {
    return this.hours;
  }

  public void setHours(byte hours) {
    this.hours = hours;
  }
}
