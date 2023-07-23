package com.ss.web.app.subject.controllers;

import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.subject.service.SubjectServiceImpl;
import com.ss.web.app.utils.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController extends BaseController<Subject, SubjectServiceImpl>{
    public SubjectController(SubjectServiceImpl service) {
        super(service);
    }
}
