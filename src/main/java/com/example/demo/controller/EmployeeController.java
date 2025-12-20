package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmployeeService;
import com.example.demo.model.Employee;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


private final EmployeeService service;


public EmployeeController(EmployeeService service) {
this.service = service;
}


@PostMapping
public Employee create(@RequestBody Employee e) {
return service.createEmployee(e);
}


@PutMapping("/{id}")
public Employee update(@PathVariable Long id, @RequestBody Employee e) {
return service.updateEmployee(id, e);
}


@GetMapping("/{id}")
public Employee get(@PathVariable Long id) {
return service.getEmployeeById(id);
}


@GetMapping
public List<Employee> all() {
return service.getAllEmployees();
}


@PutMapping("/{id}/deactivate")
public void deactivate(@PathVariable Long id) {
service.deactivateEmployee(id);
}
}