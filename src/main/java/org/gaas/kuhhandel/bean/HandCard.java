package org.gaas.kuhhandel.bean;

import java.util.HashMap;
import java.util.List;

import org.gaas.kuhhandel.eum.AnimalCardEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandCard {
	private String id;
	private HashMap<AnimalCardEnum, Integer> animalCardMap;
	private List<MoneyCard> moneyCards;
	
}
