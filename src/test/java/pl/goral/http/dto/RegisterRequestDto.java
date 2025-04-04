package pl.goral.http.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RegisterRequestDto {

    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    List<Roles> roles;

}
