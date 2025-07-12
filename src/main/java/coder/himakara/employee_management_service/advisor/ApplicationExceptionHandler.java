package coder.himakara.employee_management_service.advisor;

import coder.himakara.employee_management_service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        var problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage()
        );
        problem.setType(URI.create(""));
        problem.setTitle("Resource Not Found");
        return problem;
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRunTimeException(RuntimeException ex) {
        var problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()
        );
        problem.setType(URI.create(""));
        problem.setTitle("Internal Server Error");
        return problem;
    }
}
