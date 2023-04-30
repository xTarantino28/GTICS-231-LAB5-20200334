package com.example.gtics231lab520200334.controller;


import com.example.gtics231lab520200334.entity.Departments;
import com.example.gtics231lab520200334.entity.Employees;
import com.example.gtics231lab520200334.entity.Jobs;
import com.example.gtics231lab520200334.repository.DepartmentsRepository;
import com.example.gtics231lab520200334.repository.EmployeesRepository;
import com.example.gtics231lab520200334.repository.JobsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpleadoController {

    final EmployeesRepository employeesRepository;
    final DepartmentsRepository departmentsRepository;
    final JobsRepository jobsRepository;
    public EmpleadoController(EmployeesRepository employeesRepository,DepartmentsRepository departmentsRepository,JobsRepository jobsRepository ) {
        this.employeesRepository = employeesRepository;
        this.departmentsRepository = departmentsRepository;
        this.jobsRepository = jobsRepository;
    }



    @GetMapping("/empleados")
    public String inicioEmpleados(Model model){
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados",listaEmpleados);
        return "empleados/listar";
    }

    @GetMapping("/empleados/nuevo")
    public String empleadosNuevo(Model model){
        List<Jobs> listaPuestos = jobsRepository.findAll();
        List<Departments> listaDepartamentos = departmentsRepository.findAll();
        List<Employees> listaJefes = employeesRepository.findAll();
        model.addAttribute("listaPuestos",listaPuestos);
        model.addAttribute("listaJefes",listaJefes);
        model.addAttribute("listaDepartamentos",listaDepartamentos);
        return "empleados/nuevoEmpleado";
    }



}
