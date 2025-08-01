package coder.himakara.employee_management_service.exception;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ApplicationException {

    public static <T> Mono<T> notFoundException(String message) {
        return Mono.error(new NotFoundException(message));
    }

    public static <T> Flux<T> notFoundAnyException(String message) {
        return Flux.error(new NotFoundException(message));
    }

    public static <T> Mono<T> incorrectKeyValueException(String message) {
        return Mono.error(new IncorrectKeyValueException(message));
    }

}
