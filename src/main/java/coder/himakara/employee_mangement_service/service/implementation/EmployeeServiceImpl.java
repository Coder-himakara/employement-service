package coder.himakara.employee_mangement_service.service.implementation;

import coder.himakara.employee_mangement_service.dto.EmployeeDTO;
import coder.himakara.employee_mangement_service.exception.ApplicationException;
import coder.himakara.employee_mangement_service.mapper.EmployeeMapper;
import coder.himakara.employee_mangement_service.repository.EmployeeRepo;
import coder.himakara.employee_mangement_service.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;


    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;

    }
    @Override
    public Flux<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAll()
                .map(employeeMapper::toDTO)
                .switchIfEmpty(ApplicationException.notFoundAnyException("No employees found"));
    }
    @Override
    public Mono<EmployeeDTO> getEmployeeById(Integer employeeId) {
        return employeeRepo.findById(employeeId)
                .map(employeeMapper::toDTO)
                .switchIfEmpty(ApplicationException.notFoundException("Employee not found with id: " + employeeId));
    }
    @Override
    public Mono<EmployeeDTO> createEmployee(Mono<EmployeeDTO> employeeDTO) {
        return employeeDTO.map(employeeMapper::toEntity)
                .flatMap(employeeRepo::save)
                .map(employeeMapper::toDTO)
                .switchIfEmpty(Mono.error(new RuntimeException("Failed to create employee")));
    }
}
