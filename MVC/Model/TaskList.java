package MVC.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Observer.Subject;
import Observer.Observer;

public class TaskList implements Model , Subject {

public List<Observer> observers;
    
private ArrayList<Task> tasksList = new ArrayList<Task>();


    public TaskList() {
        observers = new ArrayList<Observer>();
    }

    //Subject methods
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update();
        }
    }

    public void removeTask(int index) {
        tasksList.remove(index);
        System.out.println("Task removed");
        notifyObservers();
    }


    @Override
    public void addTask(String taskName, String priority, boolean isComplete) {
        Task task = new Task(taskName, priority, isComplete);
        //Task task = new Task(taskName, date, priority, completed);
        tasksList.add(task);
        System.out.println("Task added");
        notifyObservers();
    }

    @Override
    public void editTask(int index, String name, Date date, String priority) {
        // TODO Auto-generated method stub
        System.out.println("edit");
    }

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

}
