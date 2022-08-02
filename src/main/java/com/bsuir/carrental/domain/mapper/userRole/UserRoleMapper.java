package com.bsuir.carrental.domain.mapper.userRole;

import com.bsuir.carrental.dao.model.userRole.UserRole;
import com.bsuir.carrental.domain.dto.userRole.UserRoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleDto toDto(UserRole userRole);

    UserRole toEntity(UserRoleDto userRoleDto);

}