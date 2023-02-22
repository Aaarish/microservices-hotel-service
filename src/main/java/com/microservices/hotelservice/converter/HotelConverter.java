package com.microservices.hotelservice.converter;

import com.microservices.hotelservice.dto.HotelDto;
import com.microservices.hotelservice.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HotelConverter {

    public HotelDto convertEntityToDto(Hotel hotel){
        HotelDto hotelDto = HotelDto.builder()
                .hotelId(hotel.getHotelId())
                .hotelName(hotel.getHotelName())
                .address(hotel.getAddress())
                .build();

        return hotelDto;
    }

    public Hotel convertDtoToEntity(HotelDto hotelDto){
        Hotel hotel = Hotel.builder()
                .hotelId(UUID.randomUUID().toString())
                .hotelName(hotelDto.getHotelName())
                .address(hotelDto.getAddress())
                .build();

        return hotel;
    }
}
