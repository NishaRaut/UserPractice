package com.bridgelabz.user.service;

import com.bridgelabz.user.dto.LoginDto;
import com.bridgelabz.user.dto.RegistrationDto;
import com.bridgelabz.user.model.Response;
import com.bridgelabz.user.model.User;

public interface UserService {
	Response userRegistration(RegistrationDto regDto) throws Exception;
	Response userLogin(LoginDto loginDto);
	Response forgetPassword(String email);
	Response resetPassword(Long id, String email);
	String verifyToken(String token)throws Exception;
	
}
