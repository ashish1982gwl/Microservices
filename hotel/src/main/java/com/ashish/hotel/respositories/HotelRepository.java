package com.ashish.hotel.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.hotel.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
