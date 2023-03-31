package net.provera.userservice.dto;

import java.util.Set;
import lombok.*;
import net.provera.userservice.dao.model.Role;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

}
