package coder.himakara.employee_management_service.dto;

import java.time.LocalDate;

public record GoalCommentResponse(
        Long id,
        Long goal,
        String commentText,
        LocalDate commentedAt
) {
}
