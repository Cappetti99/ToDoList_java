package MVC.Model;

import Observer.Subject;

import java.util.Date;
import java.util.List;
import Observer.Observer;

public interface Model {

    public abstract void addTask(String title, String priority, boolean completed);

    public abstract void removeTask(int index);

    public abstract void editTask(int index, String name, java.util.Date date, String priority);

}
