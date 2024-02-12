import MVC.Controller.ItemController;
import MVC.Model.TaskList;
import MVC.View.Frame;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        TaskList taskList = new TaskList(); //model
        ItemController itemController = new ItemController(taskList); //controller
        Frame frame = new Frame(itemController, taskList); //view
        frame.main(args);
    }

    public void run() {
        main(null);
    }
}
