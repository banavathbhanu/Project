package com.cartservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cartservice.entity.*;
import java.util.*;

public interface Cartrepository extends JpaRepository<Cart,Integer>{
	//through userid listitems in the cart
	List<Addcart> findById(int id);
	
	List<Cart> findByUid(int id);

}
