package com.ss.web.app.utils;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private static final List<Enrollment> college = new ArrayList<>();
    private static final Map<Long, Student> studentMap = new HashMap<>();
    private static final Map<Long, Subject> subjectMap = new HashMap<>();

    public static List<Enrollment> getCollege() {
        return college;
    }

    public static Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public static Map<Long, Subject> getSubjectMap() {
        return subjectMap;
    }
}
