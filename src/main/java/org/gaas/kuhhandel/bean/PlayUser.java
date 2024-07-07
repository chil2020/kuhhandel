package org.gaas.kuhhandel.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.gaas.kuhhandel.eum.AnimalCardEnum;
import org.gaas.kuhhandel.eum.ControllerTypeEnum;
import org.gaas.kuhhandel.eum.GameStatusEnum;
import org.gaas.kuhhandel.interfaces.Auctioneer;
import org.gaas.kuhhandel.interfaces.Bidder;
import org.gaas.kuhhandel.interfaces.InitiateTrader;
import org.gaas.kuhhandel.interfaces.Respondent;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayUser implements Auctioneer, Bidder, InitiateTrader, Respondent {
	private Game game;
	private String id;
	private int status; // 0: Not prepared, 1: Ready to go, 2: In the game
	private Integer weight;
	private Integer score;
	private HandCard handCard;
	
	@Override
	public void acceptBid(Bid bid) {
		if(!validBid(bid))	return;
		
		game.setBid(bid);
		game.setGameStatus(GameStatusEnum.TRADING_PLAYER_ACCEPT_BID);
		game.setController(ControllerTypeEnum.SYSTEM);
	}
	@Override
	public Bid bid(Bid bid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Card selectCard(AnimalCardEnum donkey, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HandCard changeHandCard(HandCard handCard) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MoneyCard> bid(Integer money, int number) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Card drawCard() {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean validBid(Bid bid) {
		if(!GameStatusEnum.TRADING_HOST_SPECIFY_PLAYER_AND_CARDS.equals(game.getGameStatus())) {
            return false;
        }
		
		if (!id.equals(game.getCurrentPlayerId())) {
			return false;
		}
		
		return null;
	}
	public Boolean isCurrentPlayer() {
		if (!id.equals(game.getCurrentPlayerId())) {
			System.out.println("Not current player: " + id + " != " + game.getCurrentPlayerId());
			return false;
		}
		
		if (!(GameStatusEnum.ROUND_STARTS.equals(game.getGameStatus()) || GameStatusEnum.NEXT_ROUND_STARTS.equals(game.getGameStatus()))) {
			System.out.println("Not in the right game status: " + game.getGameStatus());
			return false;
		}
		
		return true;
	}
	public List<BidOption> selectBid() {
		if (!isCurrentPlayer()) {
			return null;
		}
		List<BidOption> result = new ArrayList<>();
		HashMap<AnimalCardEnum, Integer> currentPlayerAnimalCardMap = handCard.getAnimalCardMap();
		
		ConcurrentHashMap<String, PlayUser> players = game.getRoom().getPlayers();
		for(PlayUser player : players.values()) {
			if (id.equals(player.getId())) continue;
			
			List<AnimalCardEnum> playerAnimalCardMap = new ArrayList<>();
			player.getHandCard().getAnimalCardMap().forEach((animalCard, quantity) -> {
				if (currentPlayerAnimalCardMap.containsKey(animalCard)) {
					playerAnimalCardMap.add(animalCard);
				}
				
				result.add(new BidOption(player.getId(), playerAnimalCardMap));
			});
		}
		
		game.setGameStatus(GameStatusEnum.TRADING);
		
		return result;
	}

}
