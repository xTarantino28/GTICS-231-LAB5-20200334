package com.example.gtics231lab520200334.controller;

import com.example.gtics231lab520200334.entity.Employees;
import com.example.gtics231lab520200334.repository.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    final EmployeesRepository employeesRepository;
    public HomeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;

    }



    @GetMapping(value ={"/", "/inicio"})
    public String index(){
        return "inicio";
    }

    @GetMapping("/historial")
    public String inicioHistorial(){
        return "historial/listar";
    }

    @GetMapping("/reportes")
    public String inicioReportes(){
        return "reportes/listar";
    }

}
