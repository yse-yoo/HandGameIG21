package game;

public class App {

	//メインプログラム
	public static void main(String[] args) {
		//Handインスタンスの生成
		Hand hand = new Hand();
		
		//Windowインスタンスの生成
		Window window = new Window(hand);
		//createメソッドを実行
		window.create();
	}

}
