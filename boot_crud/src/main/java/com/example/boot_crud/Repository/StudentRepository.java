package com.example.boot_crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot_crud.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
