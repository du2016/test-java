package com.ushareit.scmp.repository;

import com.ushareit.scmp.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

// StudentRepository.java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

