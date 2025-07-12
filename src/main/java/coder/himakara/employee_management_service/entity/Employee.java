package coder.himakara.employee_management_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    @Column("department_id")
    private Integer departmentId;
    @Column("manager_id")
    private Integer managerId;
}
