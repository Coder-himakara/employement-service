package coder.himakara.employee_management_service.repository;

import coder.himakara.employee_management_service.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee,Integer> {
}
