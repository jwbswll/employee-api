package com.employeecreator.employee;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "employees")
@RequiredArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  @Column(nullable = false)
  public String firstName;
  @Column(nullable = false)
  public String lastName;
  @Column(nullable = false, unique = true)
  public String email;
  @Column(nullable = true, unique = true)
  public Long mobile;
  @Column(nullable = true)
  public String address;
  @Column(nullable = false)
  public Date startDate;
  @Column(nullable = true)
  public Date endDate;
  @Column(nullable = true)
  public String contractType;
  @Column(nullable = false)
  public String contract;
  @Column(nullable = true)
  public byte hours;

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
