import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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

public class AddModePanel extends JPanel implements ActionListener{ //第20回変更
  JPanel panel;
  static JTextField categoryTextField;
  static DefaultComboBoxModel categorymodel;
  static JTextField contextTextField;
  static DefaultComboBoxModel contextmodel;
  static JTextField taskNameField; //textField1から名前変更
  static JTextField descriptionField;//textField2から名前変更
  static JSpinner spinner;
  static JCheckBox ckbox;
  static JComboBox minutecombo;
  static JComboBox categorycombo;
  static JComboBox contextcombo;
  static JComboBox hourcombo;
  public AddModePanel(){

    JPanel panel =new JPanel();
    panel.setLayout(null);
    panel.setBackground(new Color(240,240,240));
    JLabel label1 = new JLabel("タスク名:");
    label1.setBounds(30,30,60,30);
    JLabel label2 = new JLabel("メモ:");
    label2.setBounds(30,70,60,30);
    JLabel label3 = new JLabel("日付:");
    label3.setBounds(30,110,60,30);
    JTextField taskNameField = new JTextField(10);
    taskNameField.setBounds(100, 30, 200, 30);
    taskNameField.setFont(new Font("", Font.BOLD, 16));
    JTextField descriptionField = new JTextField(25);
    descriptionField.setBounds(100, 70, 450, 30);
    descriptionField.setFont(new Font("", Font.BOLD, 16));

    Calendar calendar = Calendar.getInstance();
    java.util.Date initDate = calendar.getTime();
    calendar.set(2016, 2, 1, 12, 0);
    java.util.Date startDate = calendar.getTime();

    SpinnerModel model =
        new SpinnerDateModel(initDate, startDate, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner = new JSpinner(model);

    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy.MM.dd");
    spinner.setEditor(editor);
    spinner.setBounds(100,110,200,30);

    JCheckBox ckbox = new JCheckBox("日付設定");
    ckbox.setBounds(310, 110, 100, 30);

    JLabel label4 = new JLabel("時間:");
    label4.setBounds(30,150,60,30);
    String[] hourdata ={"未指定","00","01","02","03","04","05","06","07","08","09",
     "10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    DefaultComboBoxModel hourmodel = new DefaultComboBoxModel(hourdata);
    String[] minutedata ={"未指定","00","15","30","45"};
    DefaultComboBoxModel minutemodel = new DefaultComboBoxModel(minutedata);
    JComboBox hourcombo = new JComboBox(hourmodel);
    JComboBox minutecombo = new JComboBox(minutemodel);
    hourcombo.setBounds(100,150,70,30);
    minutecombo.setBounds(175,150,70,30);

    JLabel label5 = new JLabel("カテゴリー:");
   label5.setBounds(25,190,70,30);
    String[] categorydata ={"未分類","仕事","趣味"};
    this.categorymodel = new DefaultComboBoxModel(categorydata);//第20回変更
    JComboBox categorycombo = new JComboBox(categorymodel);
    categorycombo.setBounds(100,190,100,30);
    this.categoryTextField = new JTextField(25);
    categoryTextField.setBounds(210, 190, 200, 30);
    categoryTextField.setFont(new Font("", Font.BOLD, 16));
    JButton categoryAdd = new JButton("カテゴリー追加");
    categoryAdd.setBounds(420, 190, 140, 30);
    categoryAdd.addActionListener(this);//第20回変更
    categoryAdd.setActionCommand("btn_category_add");//第20回変更

    JLabel label6 = new JLabel("コンテキスト:");
   label6.setBounds(12,230,90,30);
    String[] contextdata ={"未分類","家"};
    this.contextmodel = new DefaultComboBoxModel(contextdata);//第20回変更
    JComboBox contextcombo = new JComboBox(contextmodel);
    contextcombo.setBounds(100,230,100,30);
    this.contextTextField = new JTextField(25);
    contextTextField.setBounds(210, 230, 200, 30);
    contextTextField.setFont(new Font("", Font.BOLD, 16));
    JButton contextAdd = new JButton("コンテキスト追加");
    contextAdd.setBounds(420, 230, 140, 30);
    contextAdd.addActionListener(this);//第20回変更
    contextAdd.setActionCommand("btn_context_add");//第20回変更

    panel.add(label1);
    panel.add(taskNameField);
    panel.add(label2);
    panel.add(descriptionField);
    panel.add(label3);
    panel.add(spinner);
    panel.add(ckbox);
    panel.add(label4);
    panel.add(minutecombo);
    panel.add(hourcombo);
    panel.add(label5);
    panel.add(categorycombo);
    panel.add(categoryTextField);
    panel.add(categoryAdd);
    panel.add(label6);
    panel.add(contextcombo);
    panel.add(contextTextField);
    panel.add(contextAdd);
    JButton taskAdd = new JButton("タスク追加");
    taskAdd.setBounds(420, 280, 140, 30);
    taskAdd.addActionListener(new TaskAddListener());
    panel.add(taskAdd);

    AddModePanel.taskNameField=taskNameField;
    AddModePanel.descriptionField=descriptionField;
    AddModePanel.spinner=spinner;
    AddModePanel.ckbox=ckbox;
    AddModePanel.hourcombo=hourcombo;
    AddModePanel.minutecombo=minutecombo;
    AddModePanel.categorycombo=categorycombo;
    AddModePanel.contextcombo=contextcombo;
    this.panel=panel;
  }
  public JPanel getPanel(){
    return panel;
  }

//第20回変更
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if(cmd == "btn_category_add"){
        String newdata = categoryTextField.getText();
        if((newdata.equals("")) | (newdata == null)){
            System.out.println("null");
            return;
        }
        categorymodel.addElement(newdata);
        categoryTextField.setText("");
    }
    if(cmd == "btn_context_add"){
        String newdata = contextTextField.getText();
        if((newdata.equals("")) | (newdata == null)){
          System.out.println("null");
            return;
        }
        contextmodel.addElement(newdata);
      contextTextField.setText("");
    }
}
}