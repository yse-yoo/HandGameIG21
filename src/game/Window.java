package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		setBounds(300, 200, 800, 400);
		
		//ウィンドウを閉じた時の処理
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//ボックスレイアウト（コンポーネントを整列）
		BoxLayout boxlayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(boxlayout);
		
		//ラベルの作成
		handLabel = new JLabel("PC:", JLabel.CENTER);
		resultLabel = new JLabel("じゃんけん", JLabel.CENTER);
		
		Font font = new Font("ＭＳ ゴシック",Font.BOLD, 50);
		handLabel.setFont(font);
		resultLabel.setFont(font);
		
		resultLabel.setForeground(Color.red);
		
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
			//テキスト版
//			JButton handButton = new JButton(Hand.hands[i]);

			//アイコン画像版
			String imagePath = "./images/" + Hand.images[i];
			ImageIcon icon = new ImageIcon(imagePath);
			JButton handButton = new JButton(icon);
			
			//action commandで、グー、チョキ、パーの文字を追加
			handButton.setActionCommand(Hand.hands[i]);
			
			//イベント追加
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
