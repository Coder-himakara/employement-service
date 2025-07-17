package coder.himakara.employee_management_service.controller;

import coder.himakara.employee_management_service.dto.DepartmentDTO;
import coder.himakara.employee_management_service.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@WebFluxTest(controllers = DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockitoBean
    private DepartmentService departmentService;

    @Test
    void getDepartmentById() {
        // Create a DTO instead of entity
        DepartmentDTO department = new DepartmentDTO(1, "Human Resources");

        when(departmentService.getDepartmentById(1))
                .thenReturn(Mono.just(department));

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

}