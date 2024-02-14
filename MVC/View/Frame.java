package MVC.View;


import java.util.Scanner;

import MVC.Controller.ItemController;
import MVC.Model.TaskManager;
import Singleton.TaskList;

public class Frame extends View {
    private String RESET = "\u001B[0m";
    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";
    private String BLUE = "\u001B[34m";
    private ItemController itemController;
    private TaskManager taskManager;
    private TaskList tasks = TaskList.getInstance();

    public Frame(ItemController itemController, TaskManager taskManager) {
        this.itemController = itemController;
        this.taskManager = taskManager;
        taskManager.registerObserver(this);
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(); //model
        ItemController itemController = new ItemController(taskManager); //controller
        Frame frame = new Frame(itemController, taskManager); //view
        frame.show("");
    }

    @Override
    public void show(String input) {

        clear();
        System.out.println("Welcome to the To-Do List App!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printOption();
            int option = scanner.nextInt();
            Choice(option);
        }
    }

    public void Choice(int option){
        update();

        switch(option){
            case 1:
            {   option1();
                break;  }
            case 2:
            {   option2();
                break;  }
            case 3:
            {   option3();
                break;  }
            case 4:
            {   option4();
                break;  }
            case 5:
            {   option5();
                break;  }
            case 6:
            {   option6();
                break;  }

            default:
            {    System.out.println("Invalid option");
                break;  }
        }
    }

    @Override
    public void update() {
        
        clear();
        if(tasks.getTasksList().size() == 0)
            System.out.println(BLUE + "No tasks to show" + RESET);
        else{
            System.out.println(BLUE + "Tasks: " + RESET);
            for(int i = 0; i < tasks.getTasksList().size(); i++) {
                if(tasks.getTasksList().get(i).getIsComplete() == true){
                    System.out.println(GREEN + (i+1) + ". " + tasks.getTasksList().get(i).getTaskName() + " " + tasks.getTasksList().get(i).getPriority() + " " + tasks.getTasksList().get(i).getIsComplete() + RESET);
                } else {
                    System.out.println(RED + (i+1) + ". " + tasks.getTasksList().get(i).getTaskName() + " " + tasks.getTasksList().get(i).getPriority() + " " + tasks.getTasksList().get(i).getIsComplete() + RESET);
                }
            }
        }
    }

    public void clear(){
        System.out.print("\033[H\033[2J");
    }

    public void printOption(){
        System.out.println("Select an option: ");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Edit a task");
        System.out.println("4. Mark a task as complete/incomplete");
        System.out.println("5. Show all tasks");
        System.out.println("6. Exit");    
    }

    public void option1(){
        String taskName;
        String priority;
        System.out.println("Enter the task name: ");
        Scanner scanner = new Scanner(System.in);
        taskName = scanner.nextLine();
        System.out.println("Enter the priority (high, medium, low): ");
        priority = scanner.nextLine();
        if(!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")){
            priority = "low";
        }
        itemController.addTask(taskName, priority);

    }

    public void option2(){
        System.out.println("Select the task to remove: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        itemController.removeTask(index -1);
    }

    public void option3(){
        String taskName;
        String priority;
        System.out.println("Select the task to edit: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("Enter the new task name: ");
        Scanner scanner2 = new Scanner(System.in);
        taskName = scanner2.nextLine();
        System.out.println("Enter the new priority (high, medium, low): ");
        priority = scanner2.nextLine();
        if(!priority .equals("high") && !priority.equals("medium") && !priority.equals("low")){
            priority = "low";
        }
        itemController.editTask(index -1, taskName, priority);
    }

    public void option4(){
        System.out.println("Select the task to mark as complete: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        itemController.markTaskAsComplete(index -1);
    }

    public void option5(){
        update();
    }

    public void option6(){
        System.exit(0);
    }
}