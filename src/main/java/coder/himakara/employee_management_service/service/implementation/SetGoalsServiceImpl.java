package coder.himakara.employee_management_service.service.implementation;

import coder.himakara.employee_management_service.client.SetGoalsClient;
import coder.himakara.employee_management_service.dto.ReviewCycleRequest;
import coder.himakara.employee_management_service.dto.ReviewCycleResponse;
import coder.himakara.employee_management_service.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SetGoalsServiceImpl {
    private final SetGoalsClient setGoalsClient;
    private final EmployeeRepo employeeRepo;

    public SetGoalsServiceImpl(SetGoalsClient setGoalsClient, EmployeeRepo employeeRepo) {
        this.setGoalsClient = setGoalsClient;
        this.employeeRepo = employeeRepo;
    }

    public Mono<ReviewCycleResponse> getReviewCycleById(Long id) {
        return this.setGoalsClient.getReviewCycleById(id);
    }

    public Mono<ReviewCycleResponse> createReviewCycle(ReviewCycleRequest request) {
        return this.setGoalsClient.createReviewCycle(request);
    }
}
