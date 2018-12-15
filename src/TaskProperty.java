

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskProperty {

	//全てのPropertyを格納する
	private Map properties;


	private Date date;
	private String category;
	private String context;
	private boolean whether;
	private boolean finish;
	private Date finishDate;

	public TaskProperty(Map properties) {

		if(properties==null) {
			this.properties = new HashMap();
		}else {
			this.properties = new HashMap(properties);
		}
	}

	//propertyを1つ返すメソッド
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	//propertiesを返すメソッド
	public Map getProperties() {
		return this.properties;
	}

	public boolean matches(TaskProperty otherProperty) {

		for(Iterator i = otherProperty.getProperties().keySet().iterator() ; i.hasNext();) {
			String propertyName = (String)i.next();

			if(this.properties.get(propertyName)==null)
				return false;

			if(!properties.get(propertyName).equals(otherProperty.getProperty(propertyName)))
				return false;
		}
		return true;
	}

}

