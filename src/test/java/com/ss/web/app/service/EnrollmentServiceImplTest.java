package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.EnrollmentRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnrollmentServiceImplTest {
  @Test
  void findAllStudentsTest() {
    EnrollmentRepo repo = mock(EnrollmentRepo.class);
    EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(repo);
    List<Student> expected = new ArrayList<>();
    expected.add(new Student(1L, "Marcos", "Pro"));
    expected.add(new Student(2L, "Julio", "Noob"));

    when(repo.listStudents(1L)).thenReturn(expected);

    List<Student> students = enrollmentService.findAllStudents(1L);

    assertNotNull(students);
    assertEquals(expected, students);
  }

  @Test
  void findAllSubjectsTest() {
    EnrollmentRepo repo = mock(EnrollmentRepo.class);
    EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(repo);
    List<Subject> expected = new ArrayList<>();
    expected.add(new Subject(1L, "Calculus", "Subject1"));
    expected.add(new Subject(2L, "Chemistry", "Subject2"));

    when(repo.listSubjects(1L)).thenReturn(expected);

    List<Subject> subjects = enrollmentService.findAllSubjects(1L);

    assertNotNull(subjects);
    assertEquals(expected, subjects);
  }
}