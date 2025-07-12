package coder.himakara.employee_management_service.service;

import coder.himakara.employee_management_service.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<EmployeeDTO> getAllEmployees();
    Mono<EmployeeDTO> getEmployeeById(Integer employeeId);
    Mono<EmployeeDTO> createEmployee(Mono<EmployeeDTO> employeeDTO);
}
