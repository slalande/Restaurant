package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.restaurant.entity.Role;

public interface IRoleDAO extends JpaRepository<Role, Long> {

}
