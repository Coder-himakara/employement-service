package coder.himakara.employee_management_service.dto;

public record ReviewCycleResponse(Long reviewCycleId,
                                  String cycleName,
                                  String startDate,
                                  String endDate,
                                  Integer createdBy) {
}
