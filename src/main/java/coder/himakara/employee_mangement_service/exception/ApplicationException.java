package coder.himakara.employee_mangement_service.exception;

import reactor.core.publisher.Mono;

public class ApplicationException {

    public static <T> Mono<T> notFoundException(String message) {
        return Mono.error(new NotFoundException(message));
    }

}
