package com.example.Registerlogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Registerlogin.DTO.UserDTO;
import com.example.Registerlogin.Entity.User;
import com.example.Registerlogin.Repository.UserRepo;
import com.example.Registerlogin.Service.UserImpl;
import com.example.Registerlogin.exception.Usernotfoundexception;
@SpringBootTest
class RegisterloginApplicationTests {

	@MockBean
	UserRepo repo;
	@Autowired
	UserImpl impl;
	
	@Test
	void contextLoads() {
	}
	@Test
    public void addUser()
    {
        User a=new User();
        a.setUserid(12);
        a.setUsername("klih");
        a.setEmail("klih@gmail.com");
        a.setPassword("Abc123#8");
        when(repo.save(a)).thenReturn(a);
        assertEquals("User registered successfully",impl.adduser(a));

    }
	@Test
    public void getUserList()
    {
        User a=new User();
        a.setUserid(12);
        a.setUsername("avcd");
        a.setEmail("avcd@gmail.com");
        a.setPassword("Avcd45#9");
        when(repo.findAll()).thenReturn(Stream.of(a).collect(Collectors.toList()));
        assertEquals(1,impl.findallusers().size());

    }
	@Test
    public void getUserByIdTest() throws Usernotfoundexception
    {
        User a=new User();
        a.setUserid(12);
        a.setUsername("rohas");
        a.setEmail("rohas@gmail.com");
        a.setPassword("Roh234#89");
        when((repo).findByUserid(12)).thenReturn(a);
        User user=impl.finduserbyid(12);
        assertEquals(Optional.of(a),Optional.of(user));
    }
	
	

}
