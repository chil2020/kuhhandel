package org.gaas.kuhhandel.bean;

import java.util.List;

import org.gaas.kuhhandel.eum.AnimalCardEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BidOption {

	private String playerId;
	private List<AnimalCardEnum> animalCardList;
}
