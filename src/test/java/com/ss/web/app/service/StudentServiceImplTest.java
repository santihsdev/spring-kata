package com.ss.web.app.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.student.repository.StudentRepo;
import com.ss.web.app.student.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void save_student_not_null() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.add(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void findAll_SaveOneStudent_getSameStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Sho", "Test");
    Student[] students = { student };

    when(repo.save(student)).thenReturn(student);
    when(repo.findAll()).thenReturn(students);
    studentServiceImpl.add(student);
    Student[] expectedStudents = (Student[]) studentServiceImpl.findAll();

    assertEquals(student.getId(), expectedStudents[0].getId());
    assertEquals(student.getName(), expectedStudents[0].getName());
    assertEquals(student.getLastName(), expectedStudents[0].getLastName());
  }

  @Test
  public void findAll_empty_lengthEqualsZero() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student[] students = {  };

    when(repo.findAll()).thenReturn(students);
    Student[] expectedStudents = (Student[]) studentServiceImpl.findAll();

    assertEquals(0, expectedStudents.length);
  }

  @Test
  public void update_saveStudentThenEditName_nameEqualsTest() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Sho", "Last Name");
    Student editedValue = new Student(1L, "Test", "Last Name");

    when(repo.save(student)).thenReturn(student);
    when(repo.edit(1L,editedValue)).thenReturn(editedValue);
    studentServiceImpl.add(student);
    Student currentValue = studentServiceImpl.update(1L, editedValue);

    assertEquals(currentValue, editedValue);
  }

  @Test
  public void get_saveStudent_equalsStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Sho", "Last Name");

    when(repo.save(student)).thenReturn(student);
    when(repo.get(1L)).thenReturn(student);
    studentServiceImpl.add(student);
    Student currentValue = studentServiceImpl.get(1L);

    assertEquals(currentValue, student);
  }

  public void delete_saveStudentThenRemoveIt_Null() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(1L, "Sho", "Last Name");

    when(repo.save(student)).thenReturn(student);
    when(repo.delete(1L) ).thenReturn(student);
    when(repo.get(1L)).thenReturn(null);

    studentServiceImpl.add(student);
    studentServiceImpl.delete(1L);
    Student currentValue = studentServiceImpl.get(1L);

    assertNull(currentValue);
  }
}