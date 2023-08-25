package com.employeecreator.employee;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Email;

public class UpdateEmployeeDTO {
  public String firstName;
  public String lastName;
  @Email(message = "must be email")
  public String email;
  public Long mobile;
  public String address;
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  public Date startDate;
  public Date endDate;
  public String contractType;
  public String contract;
  public byte hours;

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
