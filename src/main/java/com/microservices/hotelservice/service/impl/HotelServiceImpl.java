package com.microservices.hotelservice.service.impl;

import com.microservices.hotelservice.converter.HotelConverter;
import com.microservices.hotelservice.dto.HotelDto;
import com.microservices.hotelservice.entity.Hotel;
import com.microservices.hotelservice.repository.HotelRepo;
import com.microservices.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HotelConverter hotelConverter;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = hotelConverter.convertDtoToEntity(hotelDto);
        Hotel savedHotel = hotelRepo.save(hotel);

        return hotelConverter.convertEntityToDto(savedHotel);
    }

    @Override
    public HotelDto getHotel(String hotelId) {
        Hotel hotel = hotelRepo.findById(hotelId).get();

        return hotelConverter.convertEntityToDto(hotel);
    }

    @Override
    public List<HotelDto> getHotels() {
        List<Hotel> hotels = hotelRepo.findAll();

        List<HotelDto> hotelDtos = hotels.stream()
                .map(h -> hotelConverter.convertEntityToDto(h))
                .collect(Collectors.toList());

        return hotelDtos;
    }

    @Override
    public String removeHotel(String hotelId) {
        hotelRepo.deleteById(hotelId);

        return "Hotel deleted successfully";
    }
}
