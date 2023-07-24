package com.ss.web.app.service;

import com.ss.web.app.subject.Subject;
import com.ss.web.app.subject.repository.SubjectRepo;
import com.ss.web.app.subject.service.SubjectServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubjectServiceImplTest {

    @Test
    public void save_subject_not_null() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl studentServiceImpl = new SubjectServiceImpl(repo);
        Subject subject = new Subject(4L, "Math", "new Class");

        when(repo.save(subject)).thenReturn(subject);
        Subject subjectExpected = studentServiceImpl.add(subject);

        assertNotNull(subjectExpected);
        assertEquals(subject, subjectExpected);
    }

    @Test
    public void findAll_SaveOneStudent_getSameStudent() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl studentServiceImpl = new SubjectServiceImpl(repo);
        Subject student = new Subject(1L, "Sho", "Test");
        Subject[] students = { student };

        when(repo.save(student)).thenReturn(student);
        when(repo.findAll()).thenReturn(students);
        studentServiceImpl.add(student);
        Subject[] expectedStudents = (Subject[]) studentServiceImpl.findAll();

        assertEquals(student.getCode(), expectedStudents[0].getCode());
        assertEquals(student.getTitle(), expectedStudents[0].getTitle());
        assertEquals(student.getDescription(), expectedStudents[0].getDescription());
    }

    @Test
    public void findAll_empty_lengthEqualsZero() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl studentServiceImpl = new SubjectServiceImpl(repo);
        Subject[] students = {  };

        when(repo.findAll()).thenReturn(students);
        Subject[] expectedStudents = (Subject[]) studentServiceImpl.findAll();

        assertEquals(0, expectedStudents.length);
    }

    @Test
    public void update_saveStudentThenEditName_nameEqualsTest() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject subject = new Subject(1L, "Sho", "Last Name");
        Subject editedValue = new Subject(1L, "Test", "Last Name");

        when(repo.save(subject)).thenReturn(subject);
        when(repo.edit(1L,editedValue)).thenReturn(editedValue);
        subjectService.add(subject);
        Subject currentValue = subjectService.update(1L, editedValue);

        assertEquals(currentValue, editedValue);
    }

    @Test
    public void get_saveStudent_equalsStudent() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject subject = new Subject(1L, "Sho", "Last Name");

        when(repo.save(subject)).thenReturn(subject);
        when(repo.get(1L)).thenReturn(subject);
        subjectService.add(subject);
        Subject currentValue = subjectService.get(1L);

        assertEquals(currentValue, subject);
    }

    public void delete_saveStudentThenRemoveIt_Null() {
        SubjectRepo repo = mock(SubjectRepo.class);
        SubjectServiceImpl subjectService = new SubjectServiceImpl(repo);
        Subject subject = new Subject(1L, "Sho", "Last Name");

        when(repo.save(subject)).thenReturn(subject);
        when(repo.delete(1L) ).thenReturn(subject);
        when(repo.get(1L)).thenReturn(null);

        subjectService.add(subject);
        subjectService.delete(1L);
        Subject currentValue = subjectService.get(1L);

        assertNull(currentValue);
    }
}
