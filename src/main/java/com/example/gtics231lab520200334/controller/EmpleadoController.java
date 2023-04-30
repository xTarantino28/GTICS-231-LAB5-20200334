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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
        List<Employees> listaEmpleados = employeesRepository.listarEmpleados();
        model.addAttribute("listaEmpleados",listaEmpleados);
        return "empleados/listar";
    }

    @PostMapping("/empleados/buscar")
    public String buscarEmpleados(@RequestParam("textoBuscar") String searchText, Model model){
        List<Employees> listaEmpleados = employeesRepository.buscarEmpleados(searchText);
        model.addAttribute("listaEmpleados",listaEmpleados);
        model.addAttribute("textoBuscado",searchText);
        return "empleados/listar";
    }

    @GetMapping("/empleados/nuevo")
    public String empleadosNuevo(Model model){
        List<Jobs> listaPuestos = jobsRepository.findAll();
        List<Departments> listaDepartamentos = departmentsRepository.findAll();
        List<Employees> listaJefes = employeesRepository.listarEmpleados();
        model.addAttribute("listaPuestos",listaPuestos);
        model.addAttribute("listaJefes",listaJefes);
        model.addAttribute("listaDepartamentos",listaDepartamentos);
        return "empleados/nuevoEmpleado";
    }

    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(
           @RequestParam("nombre") String nombre,
           @RequestParam("apellido") String apellido,
           @RequestParam("email") String email,
           @RequestParam("contrasena") String contrasena,
           @RequestParam("puesto") String puesto_id,
           @RequestParam("sueldo") double sueldo,
           @RequestParam("jefe") int jefe_id,
           @RequestParam("departamento") int departamento_id,
           RedirectAttributes redirectAttributes
    ){

        employeesRepository.guardarEmpleado( nombre,  apellido,  email,  contrasena,  puesto_id,  sueldo,  jefe_id,  departamento_id);
        redirectAttributes.addFlashAttribute("msg","Empleado creado exitosamente");
        return "redirect:/empleados";
    }

    @GetMapping("empleados/delete")
    public String borrarEmpleado(
            @RequestParam("id") int employee_id,
            RedirectAttributes redirectAttributes
    ){

        Optional<Employees> optEmployees = employeesRepository.findById(employee_id);


        if (optEmployees.isPresent()) {
            employeesRepository.borrarEmpleado(employee_id);
            redirectAttributes.addFlashAttribute("msg","Empleado borrado exitosamente");
            return "redirect:/empleados";
        } else {
            redirectAttributes.addFlashAttribute("msgDanger","No se encontro el empleado");
            return "redirect:/empleados";
        }

    }




}
