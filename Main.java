import MVC.Controller.ItemController;
import MVC.Model.TaskManager;
import MVC.Model.TaskManager;
import MVC.View.Frame;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        TaskManager taskList = new TaskManager(); //model
        ItemController itemController = new ItemController(taskList); //controller
        Frame frame = new Frame(itemController, taskList); //view
    }

    public void run() {
        main(null);
    }
}
