package coder.himakara.employee_mangement_service.controller;

import coder.himakara.employee_mangement_service.dto.EmployeeDTO;
import coder.himakara.employee_mangement_service.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Mono<ResponseEntity<Flux<EmployeeDTO>>> getAllEmployees() {
        return employeeService.getAllEmployees()
                .collectList()
                .map(employees -> ResponseEntity.ok()
                        .header("X-Total-Count", String.valueOf(employees.size()))
                        .body(Flux.fromIterable(employees)));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EmployeeDTO>> getEmployeeById(@PathVariable Integer id) {
        return this.employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok().body(employee));
    }

    @PostMapping("/create")
    public Mono<EmployeeDTO> createEmployee(Mono<EmployeeDTO> employeeDTO) {
        return this.employeeService.createEmployee(employeeDTO);
    }

}
