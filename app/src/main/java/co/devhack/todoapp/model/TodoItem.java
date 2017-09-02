package co.devhack.todoapp.model;

/**
 * Created by krlosf on 28/08/17.
 */

public class TodoItem {
    private boolean finished;
    private String description;

    public TodoItem() {
    }

    public TodoItem(boolean finished, String description) {
        this.finished = finished;
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
