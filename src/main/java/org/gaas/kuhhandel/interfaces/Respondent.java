package org.gaas.kuhhandel.interfaces;

import java.util.List;

import org.gaas.kuhhandel.bean.Bid;
import org.gaas.kuhhandel.bean.Game;
import org.gaas.kuhhandel.bean.HandCard;
import org.gaas.kuhhandel.bean.MoneyCard;

/** 回答者
 * 
 * @author User
 *
 */
public interface Respondent {
	public List<MoneyCard> bid(Integer money,int number);
	
	public void acceptBid(Bid bid);
	
	public HandCard changeHandCard(HandCard handCard);
	
}
