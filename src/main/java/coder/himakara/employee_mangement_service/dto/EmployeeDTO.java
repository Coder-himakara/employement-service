package coder.himakara.employee_mangement_service.dto;

public record EmployeeDTO(Integer employeeId,
                          String firstName,
                          String lastName,
                          String email,
                          String jobTitle,
                          Integer departmentId,
                          Integer managerId){

}

