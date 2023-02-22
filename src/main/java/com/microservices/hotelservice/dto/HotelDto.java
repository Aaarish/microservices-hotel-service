package com.microservices.hotelservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDto {
    private String hotelId;
    private String hotelName;
    private String address;
}
