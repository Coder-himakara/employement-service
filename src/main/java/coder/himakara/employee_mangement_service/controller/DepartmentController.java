package coder.himakara.employee_mangement_service.controller;

import coder.himakara.employee_mangement_service.dto.DepartmentDTO;
import coder.himakara.employee_mangement_service.exception.ApplicationException;
import coder.himakara.employee_mangement_service.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public Flux<DepartmentDTO> getAllDepartments() {
        return this.departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<DepartmentDTO>> getDepartmentById(@PathVariable Integer id) {
        return this.departmentService.getDepartmentById(id)
                .map(department -> {
                    return ResponseEntity.ok().body(department);
                })
                .switchIfEmpty(ApplicationException.notFoundException("Department not found with id: " + id));

    }

    @PostMapping("/create")
    public Mono<DepartmentDTO> createDepartment(@RequestBody Mono<DepartmentDTO> departmentDTO) {
        return this.departmentService.createDepartment(departmentDTO);
    }
}
