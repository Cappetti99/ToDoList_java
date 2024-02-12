package MVC.Controller;

import java.sql.Date;

public interface Controller {
    
public abstract void addTask(String title, String priority);

public abstract void removeTask(int index);

public abstract void editTask(int index, String name, Date date, String priority);

}