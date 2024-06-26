
package org.gaas.kuhhandel.bean.websocket;

import java.util.concurrent.ConcurrentHashMap;

public class Room {
	private String id;
	private String name;
	private ConcurrentHashMap<String, Player> players = new ConcurrentHashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConcurrentHashMap<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(ConcurrentHashMap<String, Player> players) {
		this.players = players;
	}
}
