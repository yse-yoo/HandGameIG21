package game;

import javax.swing.JFrame;

public class Window extends JFrame{

	public void create() {
		//フレームのサイズ
		setBounds(300, 200, 300, 200);
		
		//ウィンドウを閉じた時の処理
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//フレームを表示
		setVisible(true);
	}
}
