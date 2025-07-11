package coder.himakara.employee_mangement_service.mapper;

import coder.himakara.employee_mangement_service.dto.EmployeeDTO;
import coder.himakara.employee_mangement_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    @Mapping(target = "employeeId", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);
}
