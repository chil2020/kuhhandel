package org.gaas.kuhhandel.bean;

import org.gaas.kuhhandel.eum.AnimalCardEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	private AnimalCardEnum animal;
	private int quantity;
}
