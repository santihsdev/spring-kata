package com.ss.web.app.service;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.enrollment.repository.EnrollmentRepo;
import com.ss.web.app.enrollment.service.EnrollmentService;
import com.ss.web.app.enrollment.service.EnrollmentServiceImpl;
import com.ss.web.app.student.Student;
import com.ss.web.app.student.repository.StudentRepo;
import com.ss.web.app.student.service.StudentServiceImpl;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.subject.repository.SubjectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnrollmentServiceImplTest {
    @Test
    @Autowired
    public void enroll_studentWithSubject_notNull() {
        EnrollmentRepo repo = mock(EnrollmentRepo.class);
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(repo);
        Student student = new Student(4L, "ana", "perez");
        Subject subject = new Subject(4L, "Math", "new class");
        Enrollment enrollment = new Enrollment(subject, student);

        when(repo.enroll(student.getId(), subject.getCode())).thenReturn(enrollment);
        Enrollment expected = enrollmentService.enroll(4L,4L);

        assertNotNull(expected);
        assertEquals(enrollment.getStudent(), expected.getStudent());
        assertEquals(enrollment.getSubject(), expected.getSubject());
    }

}
