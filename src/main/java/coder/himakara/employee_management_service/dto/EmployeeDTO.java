package coder.himakara.employee_management_service.dto;

public record EmployeeDTO(Integer employeeId,
                          String firstName,
                          String lastName,
                          String email,
                          String jobTitle,
                          Integer departmentId,
                          Integer managerId){

}

