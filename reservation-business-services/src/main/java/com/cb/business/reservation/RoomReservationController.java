package com.cb.business.reservation;

import com.cb.business.reservation.client.RoomService;
import com.cb.business.reservation.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RoomReservationController {
 @Autowired
 private RoomService roomService;


@RequestMapping(name="/rooms" , method= RequestMethod.GET)
 public List<Room> getAllRooms()
 {
    return this.roomService.findAll(null);
 }

}
