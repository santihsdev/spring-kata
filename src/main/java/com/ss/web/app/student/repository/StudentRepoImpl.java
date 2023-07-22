package com.ss.web.app.student.repository;

import com.ss.web.app.student.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepoImpl implements StudentRepo {
  private final Map<Long, Student> studentMap;

  public StudentRepoImpl() {
    studentMap = new HashMap<>();
    studentMap.put(1L,new Student(1L, "Sho", "Test"));
    studentMap.put(2L,new Student(2L, "Auto", "Test"));
    studentMap.put(3L,new Student(3L, "Curl", "Test"));
  }

  @Override
  public Student save(Student student) {
    return studentMap.computeIfAbsent(student.getId(), k -> student);
  }

  @Override
  public Student[] findAll() {
    return (Student[]) studentMap.values().toArray();
  }

  @Override
  public Student edit(Long id, Student student) {
    return studentMap.put(id, student);
  }

  @Override
  public Student delete(Long id) {
    return studentMap.remove(id);
  }

  @Override
  public Student get(Long idStudent) {
    return studentMap.get(idStudent);
  }
}
