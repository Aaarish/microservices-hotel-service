package com.microservices.hotelservice.controller;

import com.microservices.hotelservice.dto.HotelDto;
import com.microservices.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotelDto));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotels());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> removeHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotelService.removeHotel(hotelId));
    }
}
