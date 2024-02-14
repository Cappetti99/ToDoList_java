package Test;

import MVC.Model.TaskManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TaskListTest {
    private TaskManager taskList;

    @Before
    public void setUp() {
        taskList = new TaskManager();

    }
    /*
    @Test
    public void testAddTask() {
        taskList.addTask("Test Task", "High", false);
        assertEquals("Test Task", taskList.getTasksList().get(0).getTaskName());
        assertEquals("High", taskList.getTasksList().get(0).getPriority());
        assertFalse(taskList.getTasksList().get(0).getIsComplete());
    }

    @Test
    public void testRemoveTask() {
        taskList.addTask("Test Task", "High", true);
        taskList.removeTask(0);
        assertTrue(taskList.getTasksList().isEmpty());
    }

    @Test
    public void testEditTask() {
        taskList.addTask("Test Task", "Low", false);
        taskList.editTask(0, "Edited Task", "Low");
        assertEquals("Edited Task", taskList.getTasksList().get(0).getTaskName());
        assertEquals("Low", taskList.getTasksList().get(0).getPriority());
    }

    @Test
    public void testMarkTaskAsComplete() {
        taskList.addTask("Test Task", "Medium", false);
        taskList.markTaskAsComplete(0);
        assertTrue(taskList.getTasksList().get(0).getIsComplete());
    }
    */
}