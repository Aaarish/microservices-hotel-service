package com.microservices.hotelservice.service;

import com.microservices.hotelservice.dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto getHotel(String hotelId);

    List<HotelDto> getHotels();

    String removeHotel(String hotelId);
}
