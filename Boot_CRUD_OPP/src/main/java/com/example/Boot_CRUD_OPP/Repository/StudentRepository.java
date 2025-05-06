package com.example.Boot_CRUD_OPP.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Boot_CRUD_OPP.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByNameLike(String string);

	List<Student> findByEmailLike(String string);

	Collection<? extends Student> findByMobile(long num);

}
