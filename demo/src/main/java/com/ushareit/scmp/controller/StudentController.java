package com.ushareit.scmp.controller;

import com.ushareit.scmp.exception.ResourceNotFoundException;
import com.ushareit.scmp.mapper.StudentMapper;
import com.ushareit.scmp.model.Student;
import com.ushareit.scmp.repository.StudentRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.swagger.annotations.*;
@RestController
@RequestMapping("/students")
@Api(tags = "Student Management")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    private static final Logger logger = LogManager.getLogger(StudentController.class);
    @GetMapping("/")
    @ApiOperation("Get all students")
    public List<Student> getAllStudents(@RequestParam(required = false) String name) {
        if (name == null) {
            logger.info("get all students");
            return studentMapper.getAllStudents();
        }else {
            logger.info("get students by name");
            return studentMapper.getStudentByName(name);
        }
    }

    @PostMapping("/")
    @ApiOperation("create student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    @ApiOperation("get student")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/{id}")
    @ApiOperation("update student")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setGender(studentDetails.getGender());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete student")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
