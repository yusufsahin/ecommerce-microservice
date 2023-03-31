package net.provera.userservice.service.impl;

import net.provera.userservice.dao.RoleRepository;
import net.provera.userservice.dao.model.Role;
import net.provera.userservice.dao.model.User;
import net.provera.userservice.dto.RoleDTO;
import net.provera.userservice.exception.EntityNotFoundException;
import net.provera.userservice.mapper.RoleMapper;
import net.provera.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role= roleMapper.toRole(roleDTO);
        Role savedRole= roleRepository.save(role);
        return  roleMapper.toRoleDTO(savedRole);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> roles= roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        return roleMapper.toRoleDTO(role);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        var existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        existingRole.setName(roleDTO.getName());
        var updatedRole = roleRepository.save(existingRole);
        return roleMapper.toRoleDTO(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        roleRepository.delete(role);
    }

    @Override
    public RoleDTO findByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name : " + name));
        return roleMapper.toRoleDTO(role);
    }

    @Override
    public boolean existsByName(String name) {
        Optional<Role> roleOptional = roleRepository.findByName(name);
        return roleOptional.isPresent();
    }
}
