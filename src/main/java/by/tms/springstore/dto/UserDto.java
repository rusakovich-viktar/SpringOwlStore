package by.tms.springstore.dto;

import by.tms.springstore.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    @Size(max = 30, message = "Name should not be more 30 character")
    private String name;
    @Size(max = 30, message = "Surname should not be more 30 character")
    private String surname;
    @Email(message = "Invalid email address")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String email;
    private String gender;
    private LocalDate birthday;
    private LocalDate registrationDate;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    private boolean active;

}
