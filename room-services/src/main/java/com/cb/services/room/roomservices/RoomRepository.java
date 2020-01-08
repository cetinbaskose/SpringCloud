package com.cb.services.room.roomservices;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,String> {
    Room findByRoomNumber(String roomNumber);
}
