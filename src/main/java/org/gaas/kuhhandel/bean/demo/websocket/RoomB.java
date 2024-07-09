
package org.gaas.kuhhandel.bean.demo.websocket;

import java.util.concurrent.ConcurrentHashMap;

import org.gaas.kuhhandel.bean.PlayUser;

import lombok.Data;

@Data
public class RoomB {
	private String id;
	private String name;
	private ConcurrentHashMap<String, PlayUser> players = new ConcurrentHashMap<>();

}
