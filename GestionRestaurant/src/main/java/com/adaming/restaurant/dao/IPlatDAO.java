package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.restaurant.entity.Plat;

public interface IPlatDAO extends JpaRepository<Plat, Long>{

}
