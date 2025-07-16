package coder.himakara.employee_management_service.dto;

public record ApiResponse<T>(
        Integer code,
        String message,
        T data
) {}