package com.example.gtics231lab520200334.repository;


import com.example.gtics231lab520200334.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {



}
