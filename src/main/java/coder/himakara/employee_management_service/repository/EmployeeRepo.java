package coder.himakara.employee_management_service.repository;

import coder.himakara.employee_management_service.entity.Department;
import coder.himakara.employee_management_service.entity.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee,Integer> {

    @Query("""
    SELECT d.*
    FROM
        employee e
    INNER JOIN department d ON e.department_id = d.department_id
    WHERE e.employee_id = :id
    """)
    Mono<Department> getDepartmentByEmployee(Integer id);

}
