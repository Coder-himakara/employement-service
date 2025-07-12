package coder.himakara.employee_management_service.repository;

import coder.himakara.employee_management_service.entity.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends ReactiveCrudRepository<Department, Integer> {
}
