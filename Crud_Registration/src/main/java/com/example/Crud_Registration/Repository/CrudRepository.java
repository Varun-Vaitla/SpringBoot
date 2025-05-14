package com.example.Crud_Registration.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Crud_Registration.Entity.Registration;

public interface CrudRepository extends JpaRepository<Registration, Integer> {

}
