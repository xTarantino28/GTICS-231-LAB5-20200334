package com.example.gtics231lab520200334.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value ={"/", "/inicio"})
    public String index(){
        return "inicio";
    }

    @GetMapping("/empleados")
    public String inicioEmpleados(){
        return "empleados/listar";
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
