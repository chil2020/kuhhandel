package org.gaas.kuhhandel.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ControllerTypeEnum {
	SYSTEM(0),
	PLAYER(1);

	private int id;
}
