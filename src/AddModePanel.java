
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

public class AddModePanel extends JPanel implements ActionListener{

	JPanel panel;
	static JTextField categoryTextField ;
	static DefaultComboBoxModel categorymodel;
	static JTextField contextTextField;
	static DefaultComboBoxModel contextmodel;
	static JTextField taskNameField;
	static JTextField descriprionField;
	static JSpinner spinner;
	static JCheckBox ckbox;
	static JComboBox minutecombo;
	static JComboBox categorycombo;
	static JComboBox contextcombo;
	static JComboBox hourcombo;

	public AddModePanel() {

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));

		JLabel label1 = new JLabel("タスク名");
		label1.setBounds(30, 30, 60, 30);
		JLabel label2 = new JLabel("メモ");
		label2.setBounds(30, 70, 60, 30);
		JLabel label3 = new JLabel("日付");
		label3.setBounds(30, 110, 60, 30);
		JLabel label4 = new JLabel("時間");
		label4.setBounds(30, 150, 60, 30);
		JLabel label5 = new JLabel("カテゴリー:");
		label5.setBounds(25,190,70,30);
		JLabel label6 = new JLabel("場所:");
		label6.setBounds(25,230,90,30);

		JButton taskAdd = new JButton("タスク追加");
		taskAdd.setBounds(420, 280, 140, 30);

		taskAdd.addActionListener(new TaskAddListener());
		panel.add(taskAdd);

		//タスク名用フィールド
		JTextField textField1 = new JTextField(10);
		textField1.setBounds(100, 30, 200, 30);
		textField1.setFont(new Font("", Font.BOLD, 16));

		//メモ用フィールド
		JTextField textField2 = new JTextField(25);
		textField2.setBounds(100, 70, 450, 30);
		textField2.setFont(new Font("", Font.BOLD, 16));

		//日付
		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.set(2018,1,1,0,0);
		//2018年1月1日を最低値に設定
		Date startDate = calendar.getTime();
		SpinnerModel model = new SpinnerDateModel(initDate,startDate,null,Calendar.DAY_OF_MONTH);
		JSpinner spinner = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy.MM.dd");
		spinner.setEditor(editor);
		spinner.setBounds(100, 110, 200, 30);

		//時間
		String[] hourdata = {"未指定","00","01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","15","16","17","18","19","20","21","22","23"};
		DefaultComboBoxModel hourmodel = new DefaultComboBoxModel(hourdata);
		String[] minutedata = {"未指定","00","15","30","45"};
		DefaultComboBoxModel minutemodel = new DefaultComboBoxModel(minutedata);
		JComboBox hourcombo = new JComboBox(hourmodel);
		JComboBox minutecombo = new JComboBox(minutemodel);
		hourcombo.setBounds(100, 150, 70, 30);
		minutecombo.setBounds(175, 150, 70, 30);

		//カテゴリ
		String[] categorydata ={"未分類","仕事","趣味"};
		this.categorymodel = new DefaultComboBoxModel(categorydata);
		JComboBox categorycombo = new JComboBox(categorymodel);
		categorycombo.setBounds(100,190,100,30);
		this.categoryTextField = new JTextField(25);
		categoryTextField.setBounds(210, 190, 200, 30);
		categoryTextField.setFont(new Font("", Font.BOLD, 16));
		JButton categoryAdd = new JButton("カテゴリー追加");
		categoryAdd.setBounds(420, 190, 140, 30);
		categoryAdd.addActionListener(this);
		categoryAdd.setActionCommand("btn_category_add");

		//場所
		String[] contextdata ={"未分類","家"};
		this.contextmodel = new DefaultComboBoxModel(contextdata);
		JComboBox contextcombo = new JComboBox(contextmodel);
		contextcombo.setBounds(100,230,100,30);
		this.contextTextField = new JTextField(25);
		contextTextField.setBounds(210, 230, 200, 30);
		contextTextField.setFont(new Font("", Font.BOLD, 16));
		JButton contextAdd = new JButton("コンテキスト追加");
		contextAdd.setBounds(420, 230, 140, 30);
		contextAdd.addActionListener(this);
		contextAdd.setActionCommand("btn_context_add");

		//日付指定のcheckbox
		JCheckBox ckbox = new JCheckBox("日付指定");
		ckbox.setBounds(310, 110, 100, 30);
		panel.add(ckbox);


		panel.add(label1);
		panel.add(textField1);

		panel.add(label2);
		panel.add(textField2);

		panel.add(spinner);
		panel.add(label3);

		panel.add(minutecombo);
		panel.add(hourcombo);
		panel.add(label4);

		panel.add(categorycombo);
		panel.add(categoryTextField);
		panel.add(categoryAdd);
		panel.add(label5);
		panel.add(contextcombo);
		panel.add(contextTextField);
		panel.add(contextAdd);
		panel.add(label6);

		this.panel = panel ;

		AddModePanel.taskNameField = taskNameField;
		AddModePanel.descriprionField = descriprionField;
		AddModePanel.spinner = spinner;
		AddModePanel.ckbox=ckbox;
	    AddModePanel.hourcombo=hourcombo;
	    AddModePanel.minutecombo=minutecombo;
	    AddModePanel.categorycombo=categorycombo;
	    AddModePanel.contextcombo=contextcombo;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd=="btn_category_add") {
			String newdata = categoryTextField.getText();
			if((newdata.equals("")) | (newdata==null)) {
				return;
			}
			categorymodel.addElement(newdata);
			categoryTextField.setText("");
		}

		if(cmd=="btn_context_add") {
			String newdata = contextTextField.getText();
			if((newdata.equals("")) | (newdata==null)) {
				return;
			}
			contextmodel.addElement(newdata);
			contextTextField.setText("");
		}

	}

}
