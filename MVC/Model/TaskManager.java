package MVC.Model;

import java.util.ArrayList;
import java.util.List;

import Observer.Subject;
import Observer.Observer;
import Singleton.TaskList;

public class TaskManager implements Model , Subject {

public List<Observer> observers;
    
private TaskList tasksList = TaskList.getInstance();

    public TaskManager() {
        observers = new ArrayList<Observer>();
    }

    //Subject methods
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update();
        }
    }

    @Override
    public void removeTask(int index) {
        tasksList.remove(index);
        notifyObservers();
    }


    @Override
    public void addTask(String taskName, String priority, boolean isComplete) {
        Task task = new Task(taskName, priority, isComplete);
        tasksList.add(task);
        notifyObservers();
    }

    @Override
    public void editTask(int index, String name, String priority) {
        tasksList.get(index).setTaskName(name);
        tasksList.get(index).setPriority(priority);
        notifyObservers();
    }

    public void markTaskAsComplete(int index) {
        if(tasksList.get(index).getIsComplete() == true){
            tasksList.get(index).setIsComplete(false);
        } else if(tasksList.get(index).getIsComplete() == false){
            tasksList.get(index).setIsComplete(true);
        }
        notifyObservers();
    }


}
