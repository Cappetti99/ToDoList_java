package MVC.Controller;

public abstract class Controller {
    
public abstract void addTask(String title, String priority);

public abstract void removeTask(int index);

public abstract void editTask(int index, String name, String priority);

}
