package net.provera.userservice.service;

import net.provera.userservice.dao.model.User;
import net.provera.userservice.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
    UserDTO findByUsername(String username);

    boolean existsByUsername(String username);
}
