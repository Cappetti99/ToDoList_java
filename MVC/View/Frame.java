package MVC.View;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import MVC.Controller.ItemController;
import MVC.Model.Task;
import MVC.Model.TaskList;

public class Frame extends View {
    private ItemController itemController;
    private TaskList taskList;
    private List<Task> tasks = new ArrayList<Task>();

    public Frame(ItemController itemController, TaskList taskList) {
        this.itemController = itemController;
        this.taskList = taskList;
        taskList.registerObserver(this);
    }

public static void main(String[] args) {
        TaskList taskList = new TaskList(); //model
        ItemController itemController = new ItemController(taskList); //controller
        Frame frame = new Frame(itemController, taskList); //view
        frame.show("");
}

    @Override
    public void show(String input) {

        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Edit a task");
            System.out.println("4. Mark a task as complete/incomplete");
            System.out.println("5. Show all tasks");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            Choice(option);
        }
    }

    public void Choice(int option){
        String taskName;
        String priority;

        switch(option){
            case 1:
            {
                System.out.println("Enter the task name: ");
                Scanner scanner = new Scanner(System.in);
                taskName = scanner.nextLine();
                System.out.println("Enter the priority: ");
                priority = scanner.nextLine();
                itemController.addTask(taskName, priority);
                break;
            }
            case 2:
            {
                System.out.println("Select the task to remove: ");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();
                itemController.removeTask(index -1);
                break;
            }
                
            case 3:
            {
                System.out.println("Select the task to edit: ");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();
                System.out.println("Enter the new task name: ");
                taskName = scanner.nextLine();
                System.out.println("Enter the new priority: ");
                priority = scanner.nextLine();
                //itemController.editTask(index -1, taskName, priority);
                break;
            }
        
            case 4:
            {
                System.out.println("Select the task to mark as complete: ");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();
                //itemController.markTaskAsComplete(index -1);
                break;
            }
            case 5:
            {
                update();
                break;
            }
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    @Override
    public void update() {
        
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        System.out.println(RED + "Tasks: " + RESET);
        tasks = taskList.getTasksList();
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println(RED + i + ". " + tasks.get(i).getTaskName() + " " + tasks.get(i).getPriority() + " " + tasks.get(i).getIsComplete() + RESET);
        }
    }

}