package com.episen.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.episen.sca.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
