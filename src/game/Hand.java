package game;

import java.util.Random;

public class Hand {
	//staticはインスタンスでは利用できない
	//定数（final）
	final static String ROCK = "グー";
	final static String SCISSORS = "チョキ";
	final static String PAPER = "パー";

	//配列の定数
	final static String[] hands = {
		ROCK, SCISSORS, PAPER
	};
	
	final static String[] images = {
		"rock.png", "siccors.png", "paper.png"
	};

	//フィールド
	//インスタンス変数
	public String pcHand;
	public String playerHand;
	public String result;


	//インスタンスメソッド
	public void play(String playerHand) {
		//Playerの手
		this.playerHand = playerHand;
		System.out.println("Player:" + this.playerHand);
		
		//PCの手（ランダム）
		Random random = new Random();
		int handIndex = random.nextInt(3);
		this.pcHand = hands[handIndex];
		System.out.println("PC:" + this.pcHand);

		//ジャッジ
		if (this.playerHand == this.pcHand) {
			//Draw
			this.result = "Draw";
		} else {
			this.result = 
					( 
						(this.playerHand == ROCK && this.pcHand == SCISSORS) 
						|| (this.playerHand == SCISSORS && this.pcHand == PAPER) 
						|| (this.playerHand == PAPER && this.pcHand == ROCK) 
					)
					? "Win!" : "Lose!";
		}
		
	}

}
