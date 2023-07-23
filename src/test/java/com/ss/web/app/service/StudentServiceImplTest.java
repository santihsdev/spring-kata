package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    public void findAll() {
        //Arrange
        StudentRepo repo = mock(StudentRepo.class);
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
        Student student1 = new Student(1L, "Sho", "Test");
        Student student2 = new Student(2L, "Auto", "Test");
        List<Student> students = Arrays.asList(student1, student2);
        when(repo.findAll()).thenReturn(students);
        List<Student> studentsExpected = studentServiceImpl.findAll();

        assertNotNull(studentsExpected);
        assertEquals(2, studentsExpected.size());
        assertEquals(students, studentsExpected);
    }

    @Test
    public void edit() {
        StudentRepo repo = mock(StudentRepo.class);
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
        Student student = new Student(1L, "Sho", "Test");
        student.setName("Edited");
        when(repo.edit(student)).thenReturn(student);
        Student studentExpected = studentServiceImpl.edit(student);

        assertNotNull(studentExpected);
        assertEquals("Edited", studentExpected.getName());
        assertEquals(student, studentExpected);
    }

    @Test
    public void delete() {
        StudentRepo repo = mock(StudentRepo.class);
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
        Student student = new Student(1L, "Sho", "Test");
        when(repo.delete(student)).thenReturn(true);
        boolean isDeleted = studentServiceImpl.delete(student);

        assertTrue(isDeleted);
    }
}