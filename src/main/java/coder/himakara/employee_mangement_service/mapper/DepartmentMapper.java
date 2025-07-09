package coder.himakara.employee_mangement_service.mapper;

import coder.himakara.employee_mangement_service.dto.DepartmentDTO;
import coder.himakara.employee_mangement_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    @Mapping(target = "departmentId", ignore = true)
    Department toEntity(DepartmentDTO departmentDTO);
}
