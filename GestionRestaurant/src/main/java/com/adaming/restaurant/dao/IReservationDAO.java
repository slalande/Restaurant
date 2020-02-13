package com.adaming.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.restaurant.entity.Reservation;

public interface IReservationDAO extends JpaRepository<Reservation, Long> {

}
