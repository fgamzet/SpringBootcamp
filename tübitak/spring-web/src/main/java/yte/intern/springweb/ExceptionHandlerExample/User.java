package yte.intern.springweb.ExceptionHandlerExample;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
public record User(
        @NotBlank
        String name,
        @NotBlank(message = "surname can't be empty")
        String surname,
        @Min(12)
        @Max(100)
        Integer age,
        @NotBlank(message = "email can't be empty")
        @Email(message = "email must be valid")
        String email,
        String tcKimlikNo,
        @PastOrPresent
        LocalDate birthDate,
        @Size(max = 250)
        String address,
        @NotBlank
        String username) {

    @AssertTrue
    public boolean isUsernameValid(){
        return !username.equals("admin");
    }

}
