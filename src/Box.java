

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Box {
	private List tasks;
	public Box() {
		this.tasks = new LinkedList();
	}

	public void addTask(String name ,String description,TaskProperty p) {
		Task task = new Task(name, description, p);
		this.tasks.add(task);
	}

	public Task geTask(String name) {
		for(Iterator i = this.tasks.iterator(); i.hasNext();) {
			Task task = (Task) i.next();
			if(task.getName().equals(name)) {
				return task;
			}
		}
		return null;
	}


	public List getTask() {
		return tasks;
	}
	public List search(TaskProperty searchProperty) {
		List matchingTasks = new LinkedList();

		for(Iterator i = this.tasks.iterator() ; i.hasNext();) {
			Task task = (Task) i.next();

			if(task.geTaskProperty().matches(searchProperty))
				matchingTasks.add(task);
			}
		return matchingTasks;
		}

}
