package org.gaas.kuhhandel.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.gaas.kuhhandel.eum.AnimalCardEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bid implements Serializable{
	private static final long serialVersionUID = 7254358155240956740L;
	
	private String initiateTraderId;
	private String respondentId;
	private HashMap<AnimalCardEnum, Integer> animalCardMap;
	private List<MoneyCard> moneyCards;

}
