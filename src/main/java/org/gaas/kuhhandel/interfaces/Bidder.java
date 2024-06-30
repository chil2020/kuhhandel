package org.gaas.kuhhandel.interfaces;

import java.util.List;

import org.gaas.kuhhandel.bean.MoneyCard;

/** 投標人
 * 
 * @author User
 *
 */
public interface Bidder {
	public List<MoneyCard> bid(Integer money,int number);
}
