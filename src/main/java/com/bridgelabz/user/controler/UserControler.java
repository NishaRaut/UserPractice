package com.bridgelabz.user.controler;

import javax.validation.Valid
;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.user.dto.LoginDto;
import com.bridgelabz.user.dto.RegistrationDto;
import com.bridgelabz.user.model.Response;
import com.bridgelabz.user.service.UserService;
import com.bridgelabz.user.service.UserServiceImplimentation;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*",exposedHeaders={"Authorization"})
public class UserControler {
//	@Autowired
//UserServiceImplimentation userService;
	static Logger logger = LoggerFactory.getLogger(UserControler.class);
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Response> registration(@Valid @RequestBody RegistrationDto regDto) throws Exception {
		System.out.println("Hello" + regDto);
		Response response = userService.userRegistration(regDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody LoginDto loginDto)
	{
		Response response = userService.userLogin(loginDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PostMapping("/forget")
	public ResponseEntity<Response> forget(@RequestParam String email){
		Response response =userService.forgetPassword(email);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	
	@PutMapping("/reset/{id}")
	public ResponseEntity<Response> reset(@PathVariable Long id, @RequestParam String password){
		Response response = userService.resetPassword(id,password);
		return new ResponseEntity<Response>(response,HttpStatus.OK);	
	}
	
	@GetMapping("/verification/{token}")
	public String verifiy(@PathVariable String token) throws Exception
	{
		String response = userService.verifyToken(token);
		return response;
		
	}
 
//	@GetMapping("/get")
//	public String get() {
//		System.out.println("adzsfxdgcfhgvjhbjn");
//		return "Gjjwdkjcdkhc";
//	}
}
