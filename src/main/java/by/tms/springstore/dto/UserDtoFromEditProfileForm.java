//package by.tms.springstore.dto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class UserDtoFromEditProfileForm {
//
//
//    @Size(min = 2, max = 30, message = "Name should not be between 2 and 30 character")
//    private String name;
//    @Size(min = 2, max = 30, message = "Surname should not be between 2 and 30 character")
//    private String surname;
//    @Email(message = "Invalid email address")
//    @NotEmpty(message = "Поле не должно быть пустым")
//    private String email;
//    private String gender;
//
//}