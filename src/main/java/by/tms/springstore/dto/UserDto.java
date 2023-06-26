package by.tms.springstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

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

}
