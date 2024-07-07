package org.gaas.kuhhandel.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameStatusEnum {
	GAMES_START(100, "系統 遊戲開始"),
	ROUND_STARTS(101, "系統 回合開始"),
	NEXT_ROUND_STARTS(102, "系統 新的回合開始"),
	AUCTION(200, "玩家 選擇拍賣"),
	AUCTION_SYSTEM_CALL_THREE_TIMES_FIRST(210, "系統 喊價三次倒數開始"),
	AUCTION_SYSTEM_CALL_THREE_TIMES_SECOND(211, "系統 喊價倒數第二次"),
	AUCTION_SYSTEM_CALL_THREE_TIMES_FINAL(212, "系統 喊價倒數第三次(最後一次)"),
	AUCTION_PLAYER_CALL_PRICE_TRY(220, "玩家 喊價嘗試"),
	AUCTION_PLAYER_CALL_PRICE_SUCCESS(221, "玩家 喊價成功"),
	AUCTION_PLAYER_CALL_PRICE_FAIL(222, "玩家 喊價失敗"),
	CONFIRM_WINNING_BIDDER_FINANCIAL(230, "系統 確認得標者財力足夠"),
	AUCTION_AND_CHOOSE_BUY(240, "玩家 拍賣者選擇買下"),
	AUCTION_AND_CHOOSE_SELL(250, "玩家 拍賣者選擇賣出"),
	TRADING(300, "玩家 選擇幕後交易"),
	TRADING_HOST_SPECIFY_PLAYER_AND_CARDS(301, "玩家 指定玩家的動物與金錢卡數量"),
	TRADING_PLAYER_ACCEPT_BID(310, "玩家 被指定玩家選擇接受出價"),
	TRADING_PLAYER_DICKER(320, "玩家 被指定玩家選擇還價"),
	TRADING_PLAYER_SPECIFY_MONEY_CARDS(321, "玩家 被指定玩家選擇金錢卡"),
	TRADING_JUDGMENT_FIRST(322, "系統 第一次議價 判斷成功或平手"),
	TRADING_FINAL_HOST_SPECIFY_MONEY_CARDS(323, "玩家 第一次議價平手 發起玩家選擇金錢卡"),
	TRADING_FINAL_PLAYER_SPECIFY_MONEY_CARDS(324, "玩家 第一次議價平手 被指定玩家選擇金錢卡"),
	TRADING_JUDGMENT_FINAL(325, "系統 最後一次議價 判斷成功或平手"),
	SYSTEM_ALLOCATES_RESOURCES(400, "系統 分配動物卡與金錢卡"),
	GAMES_END(500, "系統 遊戲結束");

	private int code;
    private String desc;
}
