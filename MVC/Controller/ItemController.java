package MVC.Controller;

import MVC.Model.TaskManager;

public class ItemController implements Controller{

    TaskManager taskManager = new TaskManager();

    public ItemController(TaskManager taskManager) {
        this.taskManager = taskManager;
    }
    
    @Override
    public void addTask(String task, String priority) {
        boolean isComplete = false;   
        taskManager.addTask(task, priority, isComplete);
    }

    @Override
    public void editTask(int index, String name, String priority){
        taskManager.editTask(index, name, priority);
    }

    @Override
    public void removeTask(int index){
        taskManager.removeTask(index);
    }

    public void markTaskAsComplete(int index){
        taskManager.markTaskAsComplete(index);
    }

}
