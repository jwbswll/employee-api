package com.employeecreator.employee;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  public String firstName;
  public String lastName;
  public String email;
  public Long mobile;
  public String address;
  public Date startDate;
  public Date endDate;
  public String contractType;
  public String contract;
  public byte hours;

  Employee() {
  }

  Employee(String firstName, String lastName, String email, Long mobile, String address, Date startDate,
      Date endDate, String contractType, String contract, byte hours) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.mobile = mobile;
    this.address = address;
    this.startDate = startDate;
    this.endDate = endDate;
    this.contractType = contractType;
    this.contract = contract;
    this.hours = hours;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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
