
package org.gaas.kuhhandel.bean.demo.websocket;

import java.util.concurrent.ConcurrentHashMap;

import lombok.Data;

@Data
public class Room {
	private String id;
	private String name;
	private ConcurrentHashMap<String, Player> players = new ConcurrentHashMap<>();

}
