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
	
	/**
	 * 議價次數最多兩次
	 */
	private static final Integer MAX_TRADING_COUNT = 2;
	
	private String initiateTraderId;
	private String respondentId;
	private HashMap<AnimalCardEnum, Integer> animalCardMap;
	private List<MoneyCard> moneyCards;
	private Integer tradingCount = Integer.valueOf(0);

}
