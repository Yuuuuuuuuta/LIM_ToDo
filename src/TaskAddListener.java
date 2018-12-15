

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TaskAddListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {

		String taskName = AddModePanel.taskNameField.getText();
		if( (taskName == null) | (taskName.equals("")) )
			return;

		String description = AddModePanel.descriprionField.getText();

		Map properties = new HashMap();

		Boolean dateCheck = AddModePanel.ckbox.isSelected();

		if(dateCheck) {
			Calendar date = Calendar.getInstance();
			date.setTime((Date)AddModePanel.spinner.getValue());
			properties.put(PropertyName.STARTYEAR.toString(), date.get(Calendar.YEAR));
			properties.put(PropertyName.STARTMONTH.toString(), date.get(Calendar.MONTH));
		    properties.put(PropertyName.STARTDATE.toString(), date.get(Calendar.DATE));
		    properties.put(PropertyName.STARTWEEK.toString(), date.get(Calendar.WEEK_OF_YEAR));
		    String hour = (String)AddModePanel.hourcombo.getSelectedItem();
		    String minute = (String)AddModePanel.minutecombo.getSelectedItem();

		    if((!hour.equals("未指定")) && (!minute.equals("未指定"))) {
		    	properties.put(PropertyName.STARTHOUR.toString(),Integer.parseInt(hour));
		    	properties.put(PropertyName.STARTMINUTE.toString(), Integer.parseInt(minute));
		    }
		}
		String category = (String)AddModePanel.categorycombo.getSelectedItem();
		properties.put(PropertyName.CATEGORY.toString(), category);
		String context = (String)AddModePanel.contextcombo.getSelectedItem();
		properties.put(PropertyName.CONTEXT.toString(), context);
		properties.put(PropertyName.FINISH.toString(), false);
		Main.box.addTask(taskName,description,new TaskProperty(properties));
		properties.clear();
		AddModePanel.taskNameField.setText("");
		AddModePanel.descriprionField.setText("");

	}


}
