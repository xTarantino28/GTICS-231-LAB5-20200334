package com.example.gtics231lab520200334.repository;


import com.example.gtics231lab520200334.entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into `hr`.`employees` (`first_name`, `last_name`, `email`, `password`, `job_id`,`salary`, `manager_id`, `department_id`,`enabled` ) values ( ?1,?2,?3,?4,?5,?6,?7,?8,1) ",
            nativeQuery = true)
    void guardarEmpleado(String nombre, String apellido, String email, String contrasena, String puesto_id, double sueldo, int jefe_id, int departamento_id);


    @Query(value = "SELECT * FROM `hr`.`employees` WHERE enabled = 1",
            nativeQuery = true)
    List<Employees> listarEmpleados();

    @Transactional
    @Modifying
    @Query(value = "UPDATE `hr`.`employees` SET enabled = 0 where employee_id = ?1",
            nativeQuery = true)
    void borrarEmpleado(int employee_id);

    @Query(value = "SELECT e.* FROM employees e left join jobs j on j.job_id = e.job_id  left join departments d on d.department_id = e.department_id left join locations lo on lo.location_id = d.location_id WHERE( (lo.city like %?1%) or (e.first_name Like %?1%) or (e.last_name Like %?1%) or (j.job_title Like %?1%) )  AND enabled = 1",
            nativeQuery = true)
    List<Employees> buscarEmpleados(String searchText);


}
