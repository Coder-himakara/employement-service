package coder.himakara.employee_management_service.controller;

import coder.himakara.employee_management_service.dto.DepartmentDTO;
import coder.himakara.employee_management_service.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@WebFluxTest(controllers = DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockitoBean //@MockBean has been deprecated in favor of @MockitoBean
    private DepartmentService departmentService;

    @Test
    void getDepartmentById() {
        // Create a mock DepartmentDTO to return
        DepartmentDTO mockDepartment = new DepartmentDTO(1, "Human Resources");
        // Mock the service call to return the DTO
        when(departmentService.getDepartmentById(1))
                .thenReturn(Mono.just(mockDepartment));

        webClient
                .get()
                .uri("/api/v1/departments/{id}", 1)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(DepartmentDTO.class)
                .value(departmentDTO -> {
                    assertNotNull(departmentDTO);
                    assertEquals(1, departmentDTO.departmentId());
                    assertEquals("Human Resources", departmentDTO.departmentName());
                });
    }

    @Test
    void getAllDepartments() {
        List<DepartmentDTO> mockDepartments = List.of(
                new DepartmentDTO(1, "Human Resources"),
                new DepartmentDTO(2, "IT operations"),
                new DepartmentDTO(3, "Finance"),
                new DepartmentDTO(4, "Marketing")
        );
        when(departmentService.getAllDepartments())
                .thenReturn(Flux.fromIterable(mockDepartments));

        webClient
                .get()
                .uri("/api/v1/departments/all")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(DepartmentDTO.class)
                .hasSize(4);
    }

}