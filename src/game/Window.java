package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener {
	
	//ラベル
	JLabel handLabel;
	JLabel resultLabel;
	
	//パネル
	JPanel handPanel;
	JPanel resultPanel;
	JPanel buttonPanel;
	
	//Handのインスタンス変数
	Hand hand;
	

	//コンストラクタ（Handクラスを渡す）
	public Window(Hand hand) {
		super();
		this.hand = hand;
	}


	public void create() {
		//フレームのサイズ
		setBounds(300, 200, 300, 200);
		
		//ウィンドウを閉じた時の処理
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//ボックスレイアウト（コンポーネントを整列）
		BoxLayout boxlayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(boxlayout);
		
		//ラベルの作成
		handLabel = new JLabel("PC:", JLabel.CENTER);
		resultLabel = new JLabel("じゃんけん", JLabel.CENTER);

		//パネル作成
		handPanel = new JPanel();
		handPanel.add(handLabel);

		resultPanel = new JPanel();
		resultPanel.add(resultLabel);
		
		//JFrameにパネル追加:
		add(handPanel);
		add(resultPanel);
		
		
		//ボタン追加
		buttonPanel = new JPanel();
		for (int i = 0; i < Hand.hands.length; i++) {
			System.out.println(Hand.hands[i]);
			
			JButton handButton = new JButton(Hand.hands[i]);
			
			handButton.addActionListener(this);
			
			//パネルに追加
			buttonPanel.add(handButton);
		}
		//フレームに追加
		add(buttonPanel);


		//フレームを表示（一番最後に実行）
		setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String playerHand = e.getActionCommand();
		hand.play(playerHand);
		
		//ラベルに設定
		handLabel.setText("PC: " + hand.pcHand);
		resultLabel.setText(hand.result);
	}

}
