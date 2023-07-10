package by.tms.springstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoFromRegistrationForm {

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Username should not be between 2 and 30 character")
    private String username;
    @Email(message = "Invalid email address")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String email;
    @Size(min = 2, message = "Pass should not be less 2 character")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String password;
    private String verifyPassword;
    @Past(message = "Дата рождения не может быть в будущем")
    @NotNull(message = "Поле не должно быть пустым")
    private LocalDate birthday;


}
