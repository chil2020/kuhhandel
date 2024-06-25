package org.gaas.kuhhandel.service;

import java.util.concurrent.ConcurrentHashMap;

import org.gaas.kuhhandel.bean.websocket.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	private ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();

	public ConcurrentHashMap<String, Room> getRooms() {
		return rooms;
	}
}
