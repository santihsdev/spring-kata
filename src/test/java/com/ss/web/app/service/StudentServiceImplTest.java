package com.ss.web.app.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.student.repository.StudentRepo;
import com.ss.web.app.student.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void add() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.add(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

//  @Test
//  public void findAllTest(){
//    StudentService studentService = new StudentService();
//    studentService
//  }
}