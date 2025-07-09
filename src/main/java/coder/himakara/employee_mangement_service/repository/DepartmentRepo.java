package coder.himakara.employee_mangement_service.repository;

import coder.himakara.employee_mangement_service.entity.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends ReactiveCrudRepository<Department, Integer> {
}
