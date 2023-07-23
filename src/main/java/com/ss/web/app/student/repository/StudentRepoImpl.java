package com.ss.web.app.student.repository;

import com.ss.web.app.student.Student;
import com.ss.web.app.utils.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("studentRepoImpl")
public class StudentRepoImpl implements StudentRepo {
  private final Map<Long, Student> studentMap;

  public StudentRepoImpl() {
    studentMap = Data.getStudentMap();
    studentMap.put(1L,new Student(1L, "Sho", "Test"));
    studentMap.put(2L,new Student(2L, "Auto", "Test"));
    studentMap.put(3L,new Student(3L, "Curl", "Test"));
  }

  @Override
  public Student save(Student student) {
    return studentMap.computeIfAbsent(student.getId(), k -> student);
  }

  @Override
  public Object[] findAll() {
    return studentMap.values().toArray();
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