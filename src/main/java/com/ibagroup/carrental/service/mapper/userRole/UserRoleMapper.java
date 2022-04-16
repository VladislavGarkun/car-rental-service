package com.ibagroup.carrental.service.mapper.userRole;

import com.ibagroup.carrental.dao.model.userRole.UserRole;
import com.ibagroup.carrental.service.dto.userRole.UserRoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleDto toDto(UserRole userRole);

    UserRole toEntity(UserRoleDto userRoleDto);

}
