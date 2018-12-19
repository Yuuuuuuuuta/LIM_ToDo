import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

    public class MainFrame extends JFrame implements ActionListener{
      JPanel mainPanel;
      CardLayout layout;
      AddModePanel addModePanel;
      JPanel todayModePanel ;
      JPanel tomorrowModePanel;
      JPanel scheduleModePanel;
      JPanel somedayModePanel;
      JPanel doneModePanel;
      List<TaskView> todayTasks,tomorrowTasks,scheduleTasks,somedayTasks,doneTasks;

      public MainFrame(String title){
        setTitle(title);//Frameのタイトルの設定
        setBounds(100, 100, 900, 600);//Frameの左上x座標,y座標,幅,高さの設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//☓ボタンが押された時に終了する

        Container contentPane = getContentPane();
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(67,135,233));
        headerPanel.setPreferredSize(new Dimension(900,50));

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(120,120,120));
        sidePanel.setPreferredSize(new Dimension(190,600));

        this.addModePanel = new AddModePanel();
        /*View用のパネル追加*/
        this.todayModePanel = new JPanel();
        this.tomorrowModePanel = new JPanel();
        this.scheduleModePanel = new JPanel();
        this.somedayModePanel = new JPanel();
        this.doneModePanel = new JPanel();

        /*CardLayout*/
        this.mainPanel = new JPanel();
        this.layout = new CardLayout();
        this.mainPanel.setLayout(layout);
        this.mainPanel.add(addModePanel.getPanel(),"Add");
        this.mainPanel.add(todayModePanel,"Today");
        this.mainPanel.add(tomorrowModePanel,"Tomorrow");
        this.mainPanel.add(scheduleModePanel,"Schedule");
        this.mainPanel.add(somedayModePanel,"Someday");
        this.mainPanel.add(doneModePanel,"Done");

        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(sidePanel, BorderLayout.WEST);
        contentPane.add(mainPanel);

        JLabel headerLabel = new JLabel("To Do");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setPreferredSize(new Dimension(900, 50));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font("Century", Font.BOLD, 26));
        headerPanel.add(headerLabel,BorderLayout.CENTER);

        SideButton buttonAddMode = new SideButton("追加");
        buttonAddMode.setActionCommand("Add");
        buttonAddMode.addActionListener(this);
        SideButton buttonTodayMode = new SideButton("今日");
        buttonTodayMode.setActionCommand("Today");
        buttonTodayMode.addActionListener(this);
        SideButton buttonTomorrowMode = new SideButton("明日");
        buttonTomorrowMode.setActionCommand("Tomorrow");
        buttonTomorrowMode.addActionListener(this);
        SideButton buttonScheduleMode = new SideButton("スケジュール");
        buttonScheduleMode.setActionCommand("Schedule");
        buttonScheduleMode.addActionListener(this);
        SideButton buttonSomedayMode = new SideButton("いつか");
        buttonSomedayMode.setActionCommand("Someday");
        buttonSomedayMode.addActionListener(this);
        SideButton buttonDoneMode = new SideButton("完了済み");
        buttonDoneMode.setActionCommand("Done");
        buttonDoneMode.addActionListener(this);

        sidePanel.add(buttonAddMode);
        sidePanel.add(buttonTodayMode);
        sidePanel.add(buttonTomorrowMode);
        sidePanel.add(buttonScheduleMode);
        sidePanel.add(buttonSomedayMode);
        sidePanel.add(buttonDoneMode);
        }

        public void actionPerformed(ActionEvent e) {
          String cmd = e.getActionCommand();
          //System.out.println("MainFrame");
          if(cmd==null){
            return;
          }else{
            switch(cmd){
              case "Today" :
                Calendar calendar = Calendar.getInstance();
                Map mtProperty = new HashMap();
                mtProperty.put(PropertyName.STARTYEAR.toString(), calendar.get(Calendar.YEAR));
                mtProperty.put(PropertyName.STARTMONTH.toString(), calendar.get(Calendar.MONTH));
                mtProperty.put(PropertyName.STARTDATE.toString(), calendar.get(Calendar.DATE));
                mtProperty.put(PropertyName.STARTWEEK.toString(), calendar.get(Calendar.WEEK_OF_YEAR));
                mtProperty.put(PropertyName.FINISH.toString(), false);
                this.todayTasks=this.view(mtProperty,this.todayModePanel,cmd);
                calendar=null;
                mtProperty=null;
                break;
              case "Tomorrow" :
                Calendar tomorrow = Calendar.getInstance();
                tomorrow.add(Calendar.DATE, 1);
                Map mtProperty1 = new HashMap();
                mtProperty1.put(PropertyName.STARTYEAR.toString(), tomorrow.get(Calendar.YEAR));
                mtProperty1.put(PropertyName.STARTMONTH.toString(), tomorrow.get(Calendar.MONTH));
                mtProperty1.put(PropertyName.STARTDATE.toString(), tomorrow.get(Calendar.DATE));
                mtProperty1.put(PropertyName.STARTWEEK.toString(), tomorrow.get(Calendar.WEEK_OF_YEAR));
                mtProperty1.put(PropertyName.FINISH.toString(), false);
                this.tomorrowTasks=this.view(mtProperty1,this.tomorrowModePanel,cmd);
                tomorrow=null;
                mtProperty1=null;
                break;
              case "Schedule" :
                Map mtProperty2 = new HashMap();
                mtProperty2.put(PropertyName.WHETHER.toString(), true);
                mtProperty2.put(PropertyName.FINISH.toString(), false);
                this.scheduleTasks=this.view(mtProperty2,this.scheduleModePanel,cmd);
                mtProperty2=null;
                break;
              case "Someday" :
                Map mtProperty3 = new HashMap();
                mtProperty3.put(PropertyName.FINISH.toString(), false);
                this.somedayTasks=this.view(mtProperty3,this.somedayModePanel,cmd);
                mtProperty3=null;
                break;
              case "Done" :
                Map mtProperty4 = new HashMap();
                mtProperty4.put(PropertyName.FINISH.toString(), true);
                this.doneTasks=this.view(mtProperty4,this.doneModePanel,cmd);
                mtProperty4=null;
                break;
              default :

            }
          }
          layout.show(this.mainPanel,cmd);
        }
        public List<TaskView> view(Map pr,JPanel panel,String cmd){
          panel.removeAll();
          int n=0;//Taskを数える用の変数
          JPanel outer = new JPanel();//TaskViewを詰める用のパネル
          SpringLayout layout1 = new SpringLayout();//ScrollPaneを設定するためのレイアウト
          outer.setLayout(layout1);
          SpringLayout layout2 = new SpringLayout();//更新ボタンを設置するためのレイアウト
          panel.setLayout(layout2);
          JScrollPane scroll=new JScrollPane(outer) ;
          TaskProperty matching = new TaskProperty(pr);
          List matchingTasks = Main.box.search(matching);
          LinkedList<TaskView> taskView = new LinkedList<TaskView>();
          if(!matchingTasks.isEmpty()){
            for(Iterator i = matchingTasks.iterator(); i.hasNext();){
              Task task = (Task) i.next();
              taskView.add(new TaskView(task));
              if(n>0){
                layout1.putConstraint(SpringLayout.NORTH, taskView.get(n).getPanel(), 1, SpringLayout.SOUTH, taskView.get(n-1).getPanel());//前のタスクの1px下に配置
              }
              outer.add(taskView.get(n).getPanel());
              n=n+1;
            }
          }
          outer.setPreferredSize(new Dimension(700,61*(n)));//タスクの数に合わせてパネルのサイズを大きくする
          scroll.setPreferredSize(new Dimension(710,480));
          JButton update= new JButton("更新");
          update.setActionCommand(cmd);
          update.addActionListener(new DoneListener());
          layout2.putConstraint(SpringLayout.SOUTH, update, -10, SpringLayout.SOUTH, panel);//更新ボタンの位置設定
          layout2.putConstraint(SpringLayout.EAST, update, -10, SpringLayout.EAST, panel);
          panel.add(scroll);
          panel.add(update);
          panel.revalidate();
          return taskView;
        }
        public List<TaskView> getTaskViews(String cmd){
          switch(cmd){
          case "Today" : return this.todayTasks;
          case "Tomorrow" : return this.tomorrowTasks;
          case "Schedule" : return this.scheduleTasks;
          case "Someday" : return this.somedayTasks;
          case "Done" : return this.doneTasks;
          default : return null;
          }
        }
}