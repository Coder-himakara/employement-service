package coder.himakara.employee_management_service.service;

import coder.himakara.employee_management_service.dto.ReviewCycleRequest;
import coder.himakara.employee_management_service.dto.ReviewCycleResponse;
import reactor.core.publisher.Mono;

public interface ReviewCycleService {
    Mono<ReviewCycleResponse> createReviewCycle(ReviewCycleRequest request);
    Mono<ReviewCycleResponse> getReviewCycleById(Long id);
}
