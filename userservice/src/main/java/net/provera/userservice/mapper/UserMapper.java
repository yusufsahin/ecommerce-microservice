package net.provera.userservice.mapper;

import net.provera.userservice.dao.model.User;
import net.provera.userservice.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
