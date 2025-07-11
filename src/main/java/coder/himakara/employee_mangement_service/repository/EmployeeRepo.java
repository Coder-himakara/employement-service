package coder.himakara.employee_mangement_service.repository;

import coder.himakara.employee_mangement_service.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee,Integer> {
}
