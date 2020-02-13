package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.restaurant.entity.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Long> {

}
