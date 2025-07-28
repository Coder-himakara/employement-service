package coder.himakara.employee_management_service.client;

import coder.himakara.employee_management_service.dto.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SetGoalsClient {

    private final WebClient webClient;

    public SetGoalsClient(WebClient webClient) {
        this.webClient = webClient;
    }


    public Mono<ReviewCycleResponse> getReviewCycleById(Long id){
        return this.webClient.get()
                .uri("/set-goals/api/review-cycles/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<ReviewCycleResponse>>() {})
                .map(ApiResponse::data);
    }

    public Mono<ReviewCycleResponse> createReviewCycle(ReviewCycleRequest request){
        return this.webClient.post()
                .uri("/set-goals/api/review-cycles/add")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<ReviewCycleResponse>>() {})
                .map(ApiResponse::data);
    }

    public Mono<GoalResponse> getGoalById(Long id){
        return this.webClient.get()
                .uri("/set-goals/api/goals/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<GoalResponse>>() {})
                .map(ApiResponse::data);
    }
}
