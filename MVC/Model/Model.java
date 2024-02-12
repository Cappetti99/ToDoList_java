package MVC.Model;

public interface Model {

    public abstract void addTask(String title, String priority, boolean completed);

    public abstract void removeTask(int index);

    public abstract void editTask(int index, String name, String priority);

}
