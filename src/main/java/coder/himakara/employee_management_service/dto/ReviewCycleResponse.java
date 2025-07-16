package coder.himakara.employee_management_service.dto;


import java.time.LocalDate;

public record ReviewCycleResponse(
        Long reviewCycleId,
        String cycleName,
        LocalDate startDate,
        LocalDate endDate,
        Integer createdBy) {

}
