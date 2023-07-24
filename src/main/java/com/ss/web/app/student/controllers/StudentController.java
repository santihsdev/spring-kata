package com.ss.web.app.student.controllers;

import com.ss.web.app.student.Student;
import com.ss.web.app.student.service.StudentServiceImpl;
import com.ss.web.app.utils.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student, StudentServiceImpl> {

    public StudentController(StudentServiceImpl service) {
        super(service);
    }
}
