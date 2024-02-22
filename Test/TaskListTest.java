package Test;

import MVC.Model.TaskManager;
import Singleton.TaskList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TaskListTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();

    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("Test.TaskListTest");
    }
    
    @Test
    public void testAddTask() {
        taskManager.addTask("Test Task", "High", false);
        assertEquals(1, TaskList.getInstance().getTasksList().size());
        assertEquals("Test Task", TaskList.getInstance().getTasksList().get(0).getTaskName());
        assertEquals("High", TaskList.getInstance().getTasksList().get(0).getPriority());
        assertFalse(TaskList.getInstance().getTasksList().get(0).getIsComplete());
        TaskList.getInstance().getTasksList().clear();
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Test Task", "High", true);
        taskManager.addTask("Test Task 2", "Low", false);
        taskManager.removeTask(0);
        assertEquals(1, TaskList.getInstance().getTasksList().size());
        assertEquals("Test Task 2", TaskList.getInstance().getTasksList().get(0).getTaskName());
        assertEquals("Low", TaskList.getInstance().getTasksList().get(0).getPriority());    
        assertFalse(TaskList.getInstance().getTasksList().get(0).getIsComplete());
        TaskList.getInstance().getTasksList().clear();
        
    }

    @Test
    public void testEditTask() {
        taskManager.addTask("Test Task", "Low", false);
        taskManager.editTask(0, "Edited Task", "Low");
        assertEquals(1, TaskList.getInstance().getTasksList().size());
        assertEquals("Edited Task", TaskList.getInstance().getTasksList().get(0).getTaskName());
        assertEquals("Low", TaskList.getInstance().getTasksList().get(0).getPriority());
        TaskList.getInstance().getTasksList().clear();

    }

    @Test
    public void testMarkTaskAsComplete() {
        taskManager.addTask("Test Task", "Medium", false);
        taskManager.markTaskAsComplete(0);
        assertTrue(TaskList.getInstance().getTasksList().get(0).getIsComplete());
        TaskList.getInstance().getTasksList().clear();

    }

    @Test
    public void testMarkTaskAsIncomplete() {
        taskManager.addTask("Test Task", "Medium", true);
        taskManager.markTaskAsComplete(0);
        assertFalse(TaskList.getInstance().getTasksList().get(0).getIsComplete());
        TaskList.getInstance().getTasksList().clear();
    }
    
}