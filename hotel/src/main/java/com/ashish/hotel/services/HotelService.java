package com.ashish.hotel.services;

import java.util.List;

import com.ashish.hotel.entites.Hotel;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
