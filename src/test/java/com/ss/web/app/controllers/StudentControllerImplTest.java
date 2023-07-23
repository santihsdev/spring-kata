package com.ss.web.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.web.app.model.Student;
import com.ss.web.app.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class StudentControllerImplTest {

    @Test
    public void getAll() throws Exception {
        StudentService studentService = mock(StudentService.class);
        StudentController studentController = new StudentController();
        studentController.studentService = studentService;

        Student student1 = new Student(1L, "marco", "Test");
        Student student2 = new Student(2L, "john", "Test2");
        List<Student> students = Arrays.asList(student1, student2);

        when(studentService.findAll()).thenReturn(students);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("marco")))
                .andExpect(jsonPath("$[1].name", is("john")));
    }

}
