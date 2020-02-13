package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adaming.restaurant.entity.Client;
//@Repository
//@CrossOrigin(origins="http://localhost:4200")
public interface IClientDAO extends JpaRepository<Client, Long> {

}
