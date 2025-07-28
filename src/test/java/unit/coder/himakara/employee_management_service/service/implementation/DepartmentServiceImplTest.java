package coder.himakara.employee_management_service.service.implementation;

import coder.himakara.employee_management_service.dto.DepartmentDTO;
import coder.himakara.employee_management_service.entity.Department;
import coder.himakara.employee_management_service.mapper.DepartmentMapper;
import coder.himakara.employee_management_service.repository.DepartmentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DepartmentServiceImplTest {

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentRepo departmentRepo;

    @Mock
    private DepartmentMapper departmentMapper;

    @Test
    void getAllDepartments() {
        List<Department> mockDepartments = List.of(
                new Department(1, "Human Resources"),
                new Department(2, "IT operations")
        );

        List<DepartmentDTO> mockDTOS = List.of(
                new DepartmentDTO(1, "Human Resources"),
                new DepartmentDTO(2, "IT operations")
        );

        when(departmentRepo.findAll()).thenReturn(Flux.fromIterable(mockDepartments));

        when(departmentMapper.toDTO(mockDepartments.get(0))).thenReturn(mockDTOS.get(0));
        when(departmentMapper.toDTO(mockDepartments.get(1))).thenReturn(mockDTOS.get(1));

        Flux<DepartmentDTO> result = departmentService.getAllDepartments();
        StepVerifier.create(result)
                .expectNext(mockDTOS.get(0))
                .expectNext(mockDTOS.get(1))
                .verifyComplete();

    }

    @Test
    void getDepartmentById() {
        // Setup test data
        Department department = new Department(2, "Finance");
        DepartmentDTO departmentDTO = new DepartmentDTO(2, "Finance");

        // Mock repository and mapper behavior
        when(departmentRepo.findById(2)).thenReturn(Mono.just(department));
        when(departmentMapper.toDTO(department)).thenReturn(departmentDTO);

        Mono<DepartmentDTO> result = departmentService.getDepartmentById(2);

        StepVerifier.create(result)
                .assertNext(dto -> {
                    assertEquals(2, dto.departmentId());
                    assertEquals("Finance", dto.departmentName());
                })
                .verifyComplete();
    }

    @Test
    void createDepartment() {
        DepartmentDTO inputDTO = new DepartmentDTO(2, "Finance");
        Department department = new Department(2, "Finance");
        Department savedEntity = new Department(2, "Finance");
        DepartmentDTO resultDTO = new DepartmentDTO(2, "Finance");

        when(departmentMapper.toEntity(inputDTO)).thenReturn(department);
        when(departmentRepo.save(department)).thenReturn(Mono.just(savedEntity));
        when(departmentMapper.toDTO(savedEntity)).thenReturn(resultDTO);
    }
}