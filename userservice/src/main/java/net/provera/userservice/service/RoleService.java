package net.provera.userservice.service;


import net.provera.userservice.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO createRole(RoleDTO roleDTO);

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long id);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    void deleteRole(Long id);
    RoleDTO findByName(String name);

    boolean existsByName(String name);
}
