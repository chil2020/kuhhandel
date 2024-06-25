
package org.gaas.kuhhandel.bean.websocket;

public class Player {
	private String id;
	private int x;
	private int y;
	private int status; // 0: Not prepared, 1: Ready to go, 2: In the game

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
