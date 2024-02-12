package MVC.Model;

import java.sql.Date;

public class Task {

    private String taskName;
    //private String taskDate;
    private String priority;
    private Boolean isComplete;

    public Task(String taskName, String priority, boolean isComplete) {
        this.taskName = taskName;
        this.priority = priority;
        this.isComplete = isComplete;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }
        
}
