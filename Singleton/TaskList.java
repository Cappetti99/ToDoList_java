package Singleton;

import java.util.ArrayList;

import MVC.Model.Task;

public class TaskList {
    private static TaskList instance = null;
    private ArrayList<Task> tasksList = new ArrayList<Task>();

    private TaskList() {
    }

    public static TaskList getInstance() {
        if (instance == null) {
            instance = new TaskList();
        }
        return instance;
    }

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    public void add(Task task) {
        tasksList.add(task);
    }

    public void remove(int index) {
        tasksList.remove(index);
    }

    public Task get(int index) {
        return tasksList.get(index);
    }

    public int size() {
        return tasksList.size();
    }
}