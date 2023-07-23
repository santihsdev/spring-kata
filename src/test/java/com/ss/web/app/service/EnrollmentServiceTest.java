package com.ss.web.app.service;


import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.EnrollmentRepo;
import com.ss.web.app.repository.EnrollmentRepoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class EnrollmentServiceTest {

    @Test
    void findAllStudentsTest() {
        EnrollmentRepo repo = mock(EnrollmentRepo.class);
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(repo);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(1L, "john", "Test"));
        expected.add(new Student(2L, "maria la del barrio", "Test2"));
        when(repo.listStudents(1L)).thenReturn(expected);
        List<Student> students = enrollmentService.findAllStudents(1L);

        assertEquals(expected, students);
        verify(repo, times(1)).listStudents(1L);
    }

    @Test
    void findAllSubjectsTest() {
        EnrollmentRepo repo = mock(EnrollmentRepo.class);
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(repo);
        List<Subject> expected = new ArrayList<>();
        expected.add(new Subject(1L, "Math", "It's math"));
        expected.add(new Subject(2L, "Science", "It's science"));
        when(repo.listSubjects(1L)).thenReturn(expected);
        List<Subject> subjects = enrollmentService.findAllSubjects(1L);

        assertEquals(expected, subjects);
        verify(repo, times(1)).listSubjects(1L);
    }
}
