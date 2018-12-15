public class Task {
	private String name;
	private String description;
	private TaskProperty properties;

	public Task(String name, String description, TaskProperty p ) {
		this.name = name ;
		this.description = description ;
		this.properties = p;
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public TaskProperty geTaskProperty() {
		return properties;
	}

	public void setName(String n) {
		this.name = n;
	}
	public void setDescription(String d) {
		this.description = d ;
	}
	public void setTaskProperty(TaskProperty p) {
		this.properties = p;
	}

}
