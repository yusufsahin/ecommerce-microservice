package net.provera.userservice.mapper;

import net.provera.userservice.dao.model.Role;
import net.provera.userservice.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toRoleDTO(Role role);
    Role toRole(RoleDTO roleDTO);
}
