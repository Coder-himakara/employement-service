package coder.himakara.employee_management_service.controller;

import coder.himakara.employee_management_service.dto.GoalResponse;
import coder.himakara.employee_management_service.service.GoalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }
    @GetMapping("/{id}")
    public Mono<GoalResponse> getGoalById(@PathVariable Long id) {
        return this.goalService.getGoalById(id);
    }
}
