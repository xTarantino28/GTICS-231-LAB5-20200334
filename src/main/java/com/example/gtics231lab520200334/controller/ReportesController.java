package com.example.gtics231lab520200334.controller;


import com.example.gtics231lab520200334.dto.SalarioDto;
import com.example.gtics231lab520200334.repository.DepartmentsRepository;
import com.example.gtics231lab520200334.repository.EmployeesRepository;
import com.example.gtics231lab520200334.repository.JobsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportesController {

    final EmployeesRepository employeesRepository;
    final DepartmentsRepository departmentsRepository;
    final JobsRepository jobsRepository;
    public ReportesController(EmployeesRepository employeesRepository,DepartmentsRepository departmentsRepository,JobsRepository jobsRepository ) {
        this.employeesRepository = employeesRepository;
        this.departmentsRepository = departmentsRepository;
        this.jobsRepository = jobsRepository;
    }


    @GetMapping("/reportes")
    public String inicioReportes(){
        return "reportes/listar";
    }


    @GetMapping("/reportes/salario")
    public String reportesSalario(Model model){
        List<SalarioDto> listaSalarios = employeesRepository.obtenerReporteSalarios();
        model.addAttribute("listaSalarios",listaSalarios);
        return "reportes/salario";
    }

    @GetMapping("/reportes/aumento")
    public String reportesAumento(){
        return "reportes/aumento";
    }



}
