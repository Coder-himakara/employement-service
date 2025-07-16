package coder.himakara.employee_management_service.advisor;

import coder.himakara.employee_management_service.exception.IncorrectKeyValueException;
import coder.himakara.employee_management_service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.util.function.Consumer;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        return build(HttpStatus.NOT_FOUND,ex, problem ->{
            problem.setType(URI.create(""));
            problem.setTitle("Resource Not Found");
        });
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRunTimeException(RuntimeException ex) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, ex,problem->{
            problem.setType(URI.create(""));
            problem.setTitle("Internal Server Error");
        });
    }

    @ExceptionHandler(IncorrectKeyValueException.class)
    public ProblemDetail handleIncorrectKeyValueException(IncorrectKeyValueException ex) {
        return build(HttpStatus.BAD_REQUEST, ex,problem->{
            problem.setType(URI.create(""));
            problem.setTitle("Invalid Key Value");
        });
    }

    private ProblemDetail build(HttpStatus status, Exception ex, Consumer<ProblemDetail> consumer) {
        var problem = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        consumer.accept(problem);
        return problem;
    }
}
