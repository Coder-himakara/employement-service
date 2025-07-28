package coder.himakara.employee_management_service.service.implementation;

import coder.himakara.employee_management_service.client.SetGoalsClient;
import coder.himakara.employee_management_service.dto.GoalResponse;
import coder.himakara.employee_management_service.service.GoalService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GoalServiceImpl implements GoalService {
    private final SetGoalsClient setGoalsClient;

    public GoalServiceImpl(SetGoalsClient setGoalsClient) {
        this.setGoalsClient = setGoalsClient;
    }
    @Override
    public Mono<GoalResponse> getGoalById(Long id) {
        return this.setGoalsClient.getGoalById(id);
    }
}
