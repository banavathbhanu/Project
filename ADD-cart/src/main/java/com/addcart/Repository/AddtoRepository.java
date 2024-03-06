package com.addcart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.addcart.entity.Addcart;
import com.addcart.entity.Item;

import jakarta.transaction.Transactional;
@Repository
public interface AddtoRepository extends JpaRepository<Addcart,Integer>{
	@Query(value="SELECT c from Addcart c WHERE c.uid=:uid")

	List<Addcart> getitemsbyuid(@Param("uid") int uid);
	
	Addcart findById(int id);
	
	@Modifying
	@Transactional
	@Query("delete from Addcart a where a.pid=:pid")
	void deletebypid(@Param("pid") int pid);
	
	@Modifying
	@Transactional
	@Query("delete from Addcart a where a.uid=:uid")
	void deleteafterorder(@Param("uid") int uid);

	List<Addcart> findByPid(int pid);
}
