package com.employeecreator.employee.exceptions;

public class NotFoundException extends RuntimeException {
  String message;

  public NotFoundException(String message) {
    super();
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
