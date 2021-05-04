package com.bridgelabz.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class RegistrationDto {
//	@Length(min = 1,message="please fill the firstname")
	private String FirstName;
//	@Length(min =1,message="please fill the lastname")
	private String LastName;
//	@NotNull(message="please fill the mobile number")
	private int MobNum;
//	@NotNull(message="Email cant be empty..")
//	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Enter valid email")
	private String Email;
//	@NotNull(message="Email cant be empty..")
//	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum four characters, at least one letter and one number")
	private String Password;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getMobNum() {
		return MobNum;
	}
	public void setMobNum(int mobNum) {
		MobNum = mobNum;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
