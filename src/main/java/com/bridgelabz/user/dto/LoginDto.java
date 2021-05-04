package com.bridgelabz.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginDto {
 
@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Enter valid email")
private String Email;
@NotBlank(message="Email cant be empty..")
@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum four characters, at least one letter and one number")
private String Password;
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}
