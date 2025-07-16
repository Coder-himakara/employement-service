package coder.himakara.employee_management_service.controller;

import coder.himakara.employee_management_service.dto.ReviewCycleRequest;
import coder.himakara.employee_management_service.dto.ReviewCycleResponse;
import coder.himakara.employee_management_service.service.ReviewCycleService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/review-cycles")
public class ReviewCycleController {
    private final ReviewCycleService reviewCycleService;

    public ReviewCycleController(ReviewCycleService reviewCycleService) {
        this.reviewCycleService = reviewCycleService;
    }
    @GetMapping("/{id}")
    public Mono<ReviewCycleResponse> getReviewCycleById(@PathVariable Long id) {
        return this.reviewCycleService.getReviewCycleById(id);
    }

    @PostMapping("/create")
    public Mono<ReviewCycleResponse> createReviewCycle(@RequestBody ReviewCycleRequest request) {
        return this.reviewCycleService.createReviewCycle(request);
    }
}
