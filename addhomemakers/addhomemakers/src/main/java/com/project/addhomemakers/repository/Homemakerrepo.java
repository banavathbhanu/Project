package com.project.addhomemakers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.addhomemakers.entity.Homemaker;

@Repository
public interface Homemakerrepo extends JpaRepository<Homemaker,Integer> {

}
