package MVC.View;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import MVC.Controller.ItemController;
import MVC.Model.Task;
import MVC.Model.TaskList;

public class Frame extends View {
    static Scanner userInput = new Scanner(System.in);
    TaskList taskList;
    static ItemController itemController;
    static ArrayList<Task> list = new ArrayList<Task>();

    public Frame(ItemController itemController, TaskList taskList) {
        this.taskList = taskList;
        taskList.registerObserver(this);
        this.itemController = itemController;
    }

    @Override
    public void show() {
        System.out.println("ToDoList Creator - Create to do lists using Java.");

        while (true) {
            System.out.println("Type '1' to add a task; '2' to edit a task; '3' to remove a task");
            System.out.println("Enter a comand: ");
            System.out.print("-: ");
            Scanner scanner = new Scanner(System.in);
            int valore = scanner.nextInt();
            function(valore);
            scanner.close();    
        }
        
    }

    public void function(int valore) {
        Scanner aScanner = new Scanner(System.in);
        switch (valore) {
            case 1:{
                System.out.println("Enter the task title you want to add:");
                System.out.print("-:");
                aScanner = new Scanner(System.in);
                String task = aScanner.nextLine();
                if(task != null){
                    System.out.println("Insert Priority of the task: (h/m/l)");
                    System.out.println("-:");
                    aScanner = new Scanner(System.in);
                    String priority = aScanner.nextLine();

                    System.out.print(priority);
                    itemController.addTask(task, priority); 
                }
                break;
            }
            
            case 2:{
                    System.out.println("edit");
                    //todo modificare edit
                    itemController.editTask(0, "name", Date.valueOf("2020-01-01"), "h");
                    break;
                }

                case 3:{
                    System.out.println("Enter the task number you want to remove.");
                    int index = aScanner.nextInt();
                    itemController.removeTask(index - 1);
                    break;
                }
            default:
                break;
        }
        aScanner.close();
    }

    @Override
    public void update() {
        System.out.println("     List of Task: ");
        list = taskList.getTasksList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + "." + list.get(i).getTaskName() + " priorità: " + list.get(i).getPriority());
        }
    }
}


