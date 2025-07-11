package coder.himakara.employee_mangement_service.service;

import coder.himakara.employee_mangement_service.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<EmployeeDTO> getAllEmployees();
    Mono<EmployeeDTO> getEmployeeById(Integer employeeId);
    Mono<EmployeeDTO> createEmployee(Mono<EmployeeDTO> employeeDTO);
}
