package com.ss.web.app.student;

import java.util.Objects;

public class Student {

  private Long id;
  private String name;
  private String lastName;

  public Student() {
  }

  public Student(Long id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastName);
  }
}
