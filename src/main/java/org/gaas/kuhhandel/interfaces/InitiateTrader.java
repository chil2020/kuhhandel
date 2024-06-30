package org.gaas.kuhhandel.interfaces;

import org.gaas.kuhhandel.bean.Bid;
import org.gaas.kuhhandel.bean.Card;
import org.gaas.kuhhandel.bean.HandCard;
import org.gaas.kuhhandel.eum.AnimalCardEnum;

/** 發起交易者
 * 
 * @author User
 *
 */
public interface InitiateTrader {
	
	public Bid bid(Bid bid);
	
	@Deprecated
	public Card selectCard(AnimalCardEnum donkey, int quantity);
	
	public HandCard changeHandCard(HandCard handCard);

	
}
