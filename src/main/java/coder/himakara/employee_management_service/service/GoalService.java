package coder.himakara.employee_management_service.service;

import coder.himakara.employee_management_service.dto.GoalResponse;
import reactor.core.publisher.Mono;

public interface GoalService {
    Mono<GoalResponse> getGoalById(Long id);
}
