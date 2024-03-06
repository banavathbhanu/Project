package com.example.Registerlogin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registerlogin.DTO.LoginDTO;
import com.example.Registerlogin.DTO.UserDTO;
import com.example.Registerlogin.Entity.User;
import com.example.Registerlogin.Repository.UserRepo;
import com.example.Registerlogin.Service.UserService;
import com.example.Registerlogin.exception.Usernotfoundexception;
import com.example.Registerlogin.response.LoginMessage;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
     
	@PostMapping(path="/save")
	public String saveuser(@RequestBody @Valid User user)
	{
		return userservice.adduser(user);
	}
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
	{
		LoginMessage loginMessage=userservice.loginUser(loginDTO);
		return ResponseEntity.ok(loginMessage);
	}
	@GetMapping(path="/getusers")
	public List<User> getusers()
	{
		return userservice.findallusers();
	}
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id)throws Usernotfoundexception{
		return userservice.finduserbyid(id);
	}
	@DeleteMapping("/del/{id}")
	public String deleteuser(@PathVariable int id)
	{
		 return userservice.deletebyuser(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateuser(@PathVariable("id") int id ,@RequestBody @Valid User user)
	{
		return new ResponseEntity<>(userservice.updateuser(id,user),HttpStatus.CREATED);
	}
	
}
