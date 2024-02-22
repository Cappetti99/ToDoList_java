package MVC.View;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import MVC.Controller.ItemController;
import MVC.Model.TaskManager;
import Singleton.TaskList;

public class LetturaFileTask {

    static ItemController itemController;

    public LetturaFileTask(TaskManager taskManager){
        itemController = new ItemController(taskManager);
    }

    public void loadTasksFromFile() {
        String percorsoFile = "Archivio.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(percorsoFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(linea);

                if (tokenizer.countTokens() >= 3) {
                    String task = tokenizer.nextToken();
                    String priority = tokenizer.nextToken();
                    String completed = tokenizer.nextToken();
                    boolean mood;
                    if(completed.equals("true")){
                        mood = true;
                    }else{
                        mood = false;
                    }
                    itemController.load(task, priority, mood);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTasksToFile(){
        String percorsoFile = "Archivio.txt"; 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorsoFile))) {
            for (int i = 0; i < TaskList.getInstance().size(); i++) {
                writer.write(TaskList.getInstance().get(i).getTaskName() + " " + TaskList.getInstance().get(i).getPriority() + " " + TaskList.getInstance().get(i).getIsComplete());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
