package com.ushareit.scmp.mapper;

import com.ushareit.scmp.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentByName(String name);
    List<Student> getAllStudents();
    void insertStudent(Student user);
    void updateStudent(Student user);
    void deleteStudent(Long id);
}
