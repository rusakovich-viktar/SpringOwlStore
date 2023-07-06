package by.tms.springstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {

    @Email(regexp = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Неверный формат электронной почты")
    private String email;

    @Pattern(regexp = "^\\+375(17|29|33|44)[0-9]{3}[0-9]{2}[0-9]{2}$", message = "Введите номер в формате: +375332221100")
    private String phone;

    private String message;

}
