package com.bridgelabz.user.service;

import java.time.LocalDate;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.user.dto.LoginDto;
import com.bridgelabz.user.dto.RegistrationDto;
import com.bridgelabz.user.model.Response;
import com.bridgelabz.user.model.User;
import com.bridgelabz.user.repository.UserRepository;
import com.bridgelabz.user.service.EmailService;
import com.bridgelabz.user.utility.UserToken;;

@Service
public class UserServiceImplimentation implements UserService {

	ModelMapper mapper= new ModelMapper();
	@Autowired
	UserRepository userRepository;
	@Autowired
	ResponseImplementation reponseImpl;
	@Autowired
	EmailService emailService;
	@Autowired
	UserToken userToken;
	
	//@Autowired
	//RabbitMQSender rabbitMQSender;
	
	
	@Override
	public Response userRegistration(RegistrationDto regDto) throws Exception,NullPointerException {
		Optional<User> optinalUser = userRepository.findByEmail(regDto.getEmail());
		if(optinalUser.isEmpty())
		{
			User userReg = mapper.map(regDto,User.class);
			System.out.println(userReg);
			LocalDate today = LocalDate.now();
			userReg.setRegisteredDate(today);
			userRepository.save(userReg);
			String token =userToken.generateToken(userReg.getId());
			String userActivationLink = "http://localhost:8080/user/verification/";
			userActivationLink=userActivationLink+token;
			//emailService.sendMail("nisha.raut@bridgelabz.com", "subject", userActivationLink);
//rabbitMQSender.send(userActivationLink);
			return new Response ("user reg success",200); 
			
		}
		return new Response ("already exist",400); 
		
	}
	
	

	@Override
	public Response userLogin(LoginDto loginDto) {
		Optional<User> OptionalUser = userRepository.findByEmail(loginDto.getEmail());
		if(OptionalUser.get().getEmail().equals(loginDto.getEmail()) && OptionalUser.get().getPassword().equals(loginDto.getPassword()))
			return new Response("login successs",200);
		return new Response("user not found",400);
	}

	@Override
	public Response forgetPassword(String email) {
		Optional<User> user=userRepository.findByEmail(email);
		System.out.println("User: "+user);
		if(user == null)
			 return new Response ("user not found",404);
		return new Response ("success ",200);	
	}

	@Override
	public Response resetPassword(Long id ,String password) {
		System.out.println("emai>>>>"+id);
		System.out.println("password>>>>"+password);
		Optional<User> optionalUser = userRepository.findById(id);
		System.out.println(optionalUser);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setPassword(password);
			userRepository.save(user);
			return new Response("success",200);
		}
		return new Response("Invalid user", 500);
	}



	@Override
	public String verifyToken(String token) throws Exception {
		Long id = userToken.tokenVerify(token);
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found")); 
		user.setVerify(true);
		userRepository.save(user);
		return "user verify successfuly";
	}

}
