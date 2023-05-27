package by.tms.springstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Entity
@Table(name = "users", schema = "online-store")
@NoArgsConstructor
@AllArgsConstructor
public class User /*extends UserDto */ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_key")
    private String username;
    @Column(name = "first_name")
    private String name;
    @Column(name = "second_name")
    private String surname;
    private String gender;
    @Column(name = "day_of_birthday")
    private String birthday;
    private String email;
//    @Column(name = "registration_date")
//    private LocalDate registrationDate;
    @Column(name = "pass_value")
    private String password;

//    public User(Long id, String username, String name, String surname, String gender, String birthday, String email, String registrationDate, String password) {
//        super(id, username, name, surname, gender, birthday, email, registrationDate);
//        this.password = password;
//    }

//    public User(String username, String name, String surname, String gender, String birthday, String email, String registrationDate, String password) {
//        super(username, name, surname, gender, birthday, email, registrationDate);
//        this.password = password;
//    }

    public User(String username, String name, String surname, String gender, String birthday, String email, /*LocalDate registrationDate,*/ String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
//        this.registrationDate = registrationDate;
        this.password = password;
    }
}
