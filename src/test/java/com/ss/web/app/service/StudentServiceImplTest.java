package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void addStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void findAllTest() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    List<Student> students = new ArrayList<>();
    students.add(new Student(1L, "Sho", "Test"));
    students.add(new Student(2L, "Auto", "Test"));
    students.add(new Student(3L, "Curl", "Test"));

    when(repo.findAll()).thenReturn(students);

    List<Student> studentsExpected = studentServiceImpl.findAll();

    assertNotNull(studentsExpected);
    assertEquals(students, studentsExpected);
  }

  @Test
  public void edit_EditExistingStudent_StudentEdited() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Yo", "Test");

    when(repo.edit(student)).thenReturn(student);

    Student expectedStudent = studentServiceImpl.edit(student);

    assertNotNull(expectedStudent);
    assertEquals(student.getName(), expectedStudent.getName());
    assertEquals(student, expectedStudent);
  }

  @Test
  public void delete_DeleteExistingStudent_StudentDeleted() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(2L, "Auto", "Test");

    when(repo.delete(student)).thenReturn(true);

    boolean expectedStudent = studentServiceImpl.delete(student);

    assertTrue(expectedStudent);
  }

  @Test
  public void delete_DeleteNonExistingStudent_StudentDeleted() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(5L, "Pro", "Test");

    when(repo.delete(student)).thenReturn(false);

    boolean expectedStudent = studentServiceImpl.delete(student);

    assertFalse(expectedStudent);
  }

}