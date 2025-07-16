package coder.himakara.employee_management_service.client;

import coder.himakara.employee_management_service.dto.ApiResponse;
import coder.himakara.employee_management_service.dto.ReviewCycleRequest;
import coder.himakara.employee_management_service.dto.ReviewCycleResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SetGoalsClient {

    private final WebClient webClient;

    public SetGoalsClient(WebClient webClient) {
        this.webClient = webClient;
    }


    public Mono<ReviewCycleResponse> getReviewCycleById(Long Id){
        return this.webClient.get()
                .uri("/set-goals/api/review-cycles/{id}", Id)
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
}
