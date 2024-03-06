package com.example.Registerlogin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Registerlogin.DTO.LoginDTO;
import com.example.Registerlogin.DTO.UserDTO;
import com.example.Registerlogin.Entity.User;
import com.example.Registerlogin.Repository.UserRepo;
import com.example.Registerlogin.exception.Usernotfoundexception;
import com.example.Registerlogin.response.LoginMessage;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private PasswordEncoder passencoder;
	
	@Override
	public  String adduser(User user) {
		System.out.println("hi");
		System.out.println(user.getUsername());
		user.setPassword(this.passencoder.encode(user.getPassword()));
		if(userrepo.findByEmail(user.getEmail())!=null)

        {

            return("User Already Exists");

        }
		
		 userrepo.save(user);
		 return "User registered successfully";
				
		
	}
	public User updateuser(int id,User user) {
		System.out.println("hi");
		User u=userrepo.findById(id).get();
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setPassword(this.passencoder.encode(user.getPassword()));
		return userrepo.save(u);
	}
	public List<User> findallusers()
	{
		return userrepo.findAll();
	}
	public User finduserbyid(int id) throws Usernotfoundexception
	{
		
		
		User user= userrepo.findByUserid(id);
		if(user==null)
		{
			throw new Usernotfoundexception("User not found");
		}
		else
		{
			return user;
		}
		
	}
	public String deletebyuser(int id)
	{
		userrepo.deleteById(id);
		return "deleted";
	}
	UserDTO userDTO;
	
	@Override
	public LoginMessage loginUser(LoginDTO loginDTO) {
		String msg="";
		User user1=userrepo.findByEmail(loginDTO.getEmail());
		if(user1!=null)
		{
			String pass=loginDTO.getPassword();
			String encodedpassword=user1.getPassword();
			Boolean isPwdRight=passencoder.matches(pass, encodedpassword);
			if(isPwdRight)
			{
				Optional<User> user=userrepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedpassword);
				if(user.isPresent())
				{
					return new LoginMessage(user1.getUserid(),"Login Success",true);
				}
				else
				{
					return new LoginMessage(0,"Login Failed",false);
				}
			}
			else
			{
				return new LoginMessage(0,"password does not match",false);
			}
		}
		else
		{
			return new LoginMessage(0,"Email Does not exist",false);
		}
		
	}
	

}
