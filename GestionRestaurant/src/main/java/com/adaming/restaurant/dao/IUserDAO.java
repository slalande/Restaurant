package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.restaurant.entity.User;

public interface IUserDAO extends JpaRepository<User, Long> {

}
