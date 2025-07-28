package coder.himakara.employee_management_service.dto;

import java.time.LocalDate;
import java.util.List;

public record GoalResponse(
         Long goalId,
         String title,
         String description,
         String status,
         LocalDate createdDate,
         LocalDate dueDate,
         Integer employeeId,
         Long reviewCycle,
         List<GoalCommentResponse>comments) {
}
