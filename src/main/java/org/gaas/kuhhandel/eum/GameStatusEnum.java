package org.gaas.kuhhandel.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameStatusEnum {
	GAMES_START(100, "系統 遊戲開始"),
	ROUND_STARTS(101, "系統 回合開始"),
	AUCTION(200, "玩家 選擇拍賣"),
	AUCTION_SYSTEM_CALL_THREE_TIMES(210, "系統 喊價三次倒數開始"),
	AUCTION_PLAYER_CALL_PRICE_TRY(220, "玩家 喊價嘗試"),
	AUCTION_PLAYER_CALL_PRICE_SUCCESS(221, "玩家 喊價成功"),
	AUCTION_PLAYER_CALL_PRICE_FAIL(222, "玩家 喊價失敗"),
	CONFIRM_WINNING_BIDDER_FINANCIAL(230, "系統 確認得標者財力足夠"),
	AUCTION_AND_CHOOSE_BUY(240, "玩家 拍賣者選擇買下"),
	AUCTION_AND_CHOOSE_SELL(250, "玩家 拍賣者選擇賣出"),
	TRADING(300, "玩家 選擇幕後交易"),
	TRADING_PLAYER_ACCEPT_BID(310, "玩家 被指定玩家選擇接受出價"),
	TRADING_PLAYER_DICKER(320, "玩家 被指定玩家選擇還價"),
	TRADING_FINAL_HOST_SPECIFY_MONEY_CARDS(321, "玩家 第一次議價平手 發起玩家選擇金錢卡"),
	TRADING_FINAL_PLAYER_SPECIFY_MONEY_CARDS(322, "玩家 第一次議價平手 被指定玩家選擇金錢卡"),
	TRADING_JUDGMENT(330, "系統 判斷議價價高者或平手，與分配金錢卡與動物卡"),
	GAMES_END(500, "系統 遊戲結束");

	private int code;
    private String desc;
}
