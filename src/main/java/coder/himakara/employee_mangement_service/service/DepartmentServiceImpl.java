package coder.himakara.employee_mangement_service.service;

import coder.himakara.employee_mangement_service.dto.DepartmentDTO;
import coder.himakara.employee_mangement_service.exception.ApplicationException;
import coder.himakara.employee_mangement_service.mapper.DepartmentMapper;
import coder.himakara.employee_mangement_service.repository.DepartmentRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo, DepartmentMapper departmentMapper) {
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Flux<DepartmentDTO> getAllDepartments() {
        return departmentRepo.findAll()
                .map(departmentMapper::toDTO)
                .switchIfEmpty(ApplicationException.notFoundAnyException("No departments are found"));
    }
    @Override
    public Mono<DepartmentDTO> getDepartmentById(Integer departmentId) {
        return departmentRepo.findById(departmentId)
                .map(departmentMapper::toDTO)
                .switchIfEmpty(ApplicationException.notFoundException("Department not found with id: " + departmentId));
    }
    @Override
    public Mono<DepartmentDTO> createDepartment(Mono<DepartmentDTO> departmentDTO) {
        return departmentDTO.map(departmentMapper::toEntity)
                .flatMap(departmentRepo::save)
                .map(departmentMapper::toDTO);
    }
}
