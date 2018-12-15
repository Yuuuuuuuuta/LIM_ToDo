import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public MainFrame(String title) {
		//Frameのタイトル
		setTitle(title);
		//Frameの座標、幅、高さ指定
		setBounds(100,100,900,600);
		//×ボタンが押された時に終了するように設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ContentPane(画用紙的な何か)の呼び出し
		Container contentPane = getContentPane();
		//headerパネルの設定
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(67,135,233));
		headerPanel.setPreferredSize(new Dimension(900,50));

		//sideパネルの設定
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(120,120,120));
		sidePanel.setPreferredSize(new Dimension(190,600));

		AddModePanel addModePanel = new AddModePanel();

		//ContentPaneにパネルを追加
		contentPane.add(headerPanel, BorderLayout.NORTH);
		contentPane.add(sidePanel, BorderLayout.WEST);
		contentPane.add(addModePanel.getPanel());

		//Labelの設定
		JLabel headerLabel = new JLabel("To Do");
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setPreferredSize(new Dimension(900,50));
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("Century", Font.BOLD, 22));
		headerPanel.add(headerLabel,BorderLayout.CENTER);

		//ボタンの追加
		SideButton buttonAddMode = new SideButton("追加");
		SideButton buttonTodayMode = new SideButton("今日");
		SideButton buttonScheduleMode = new SideButton("スケジュール");
		SideButton buttonSomedayMode = new SideButton("いつか");
		SideButton buttonDoneMode = new SideButton("完了済み");
		sidePanel.add(buttonAddMode);
		sidePanel.add(buttonTodayMode);
		sidePanel.add(buttonScheduleMode);
		sidePanel.add(buttonSomedayMode);
		sidePanel.add(buttonDoneMode);

	}


}
