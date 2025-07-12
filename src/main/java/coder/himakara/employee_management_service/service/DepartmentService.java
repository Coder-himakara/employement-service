package coder.himakara.employee_management_service.service;

import coder.himakara.employee_management_service.dto.DepartmentDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartmentService {
    Flux<DepartmentDTO> getAllDepartments();
    Mono<DepartmentDTO> getDepartmentById(Integer departmentId);
    Mono<DepartmentDTO> createDepartment(Mono<DepartmentDTO> departmentDTO);
}
