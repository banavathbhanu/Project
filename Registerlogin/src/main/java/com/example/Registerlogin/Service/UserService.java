package com.example.Registerlogin.Service;


import java.util.List;
import java.util.Optional;

import com.example.Registerlogin.DTO.LoginDTO;
import com.example.Registerlogin.DTO.UserDTO;
import com.example.Registerlogin.Entity.User;
import com.example.Registerlogin.exception.Usernotfoundexception;
import com.example.Registerlogin.response.LoginMessage;

public interface UserService {
	
	String adduser(User user);
	User updateuser(int id,User user);
	List<User> findallusers();
	User finduserbyid(int id)throws Usernotfoundexception;
	
	LoginMessage loginUser(LoginDTO loginDTO);
	String deletebyuser(int id);

}
