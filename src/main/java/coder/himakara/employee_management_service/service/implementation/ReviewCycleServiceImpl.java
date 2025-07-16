package coder.himakara.employee_management_service.service.implementation;

import coder.himakara.employee_management_service.client.SetGoalsClient;
import coder.himakara.employee_management_service.dto.ReviewCycleRequest;
import coder.himakara.employee_management_service.dto.ReviewCycleResponse;
import coder.himakara.employee_management_service.exception.ApplicationException;
import coder.himakara.employee_management_service.repository.EmployeeRepo;
import coder.himakara.employee_management_service.service.ReviewCycleService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReviewCycleServiceImpl implements ReviewCycleService {
    private final SetGoalsClient setGoalsClient;
    private final EmployeeRepo employeeRepo;

    public ReviewCycleServiceImpl(SetGoalsClient setGoalsClient, EmployeeRepo employeeRepo) {
        this.setGoalsClient = setGoalsClient;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Mono<ReviewCycleResponse> getReviewCycleById(Long id) {
        return this.setGoalsClient.getReviewCycleById(id);
    }

    @Override
    public Mono<ReviewCycleResponse> createReviewCycle(ReviewCycleRequest request) {
        return validateEmployee(request.createdBy())
                .then(this.setGoalsClient.createReviewCycle(request));
    }

    private Mono<Void> validateEmployee(Integer employeeId) {
        return employeeRepo.findById(employeeId)
                .switchIfEmpty(ApplicationException.notFoundException("Employee not found with ID: " + employeeId))
                .flatMap(employee -> {
                    // Check if employee is HR-executive
                    if (!"HR-executive".equals(employee.getJobTitle())) {
                        return ApplicationException.incorrectKeyValueException("Invalid job title");
                    }

                    // Check if the employee is in HR department
                    return employeeRepo.getDepartmentByEmployee(employeeId)
                            .flatMap(department -> {
                                if (!"Human Resource".equals(department.getDepartmentName())) {
                                    return ApplicationException.incorrectKeyValueException("Employee is not in HR department");
                                }
                                return Mono.empty();
                            });
                })
                .then();
    }

}
