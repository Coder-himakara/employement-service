package coder.himakara.employee_management_service.dto;

import java.time.LocalDate;

public record ReviewCycleRequest(String cycleName,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 Integer employeeId) {
}
