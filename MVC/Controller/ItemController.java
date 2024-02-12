package MVC.Controller;

import java.sql.Date;

import MVC.Model.TaskList;

public class ItemController implements Controller{

    TaskList taskList = new TaskList();

    public ItemController(TaskList taskList) {
        this.taskList = taskList;
    }
    
    @Override
    public void addTask(String task, String priority) {
        System.out.println("before addTask in ItemController");
        boolean isComplete = false;   
        taskList.addTask(task, priority, isComplete);
    }

    @Override
    public void editTask(int index, String name, Date date, String priority){
        System.out.println("edit");
    }

    @Override
    public void removeTask(int index){
        taskList.removeTask(index);
        System.out.println("remove");
    }

}
