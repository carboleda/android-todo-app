package co.devhack.todoapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by krlosf on 28/08/17.
 */
@DatabaseTable(tableName = "todo")
public class TodoItem {
    public static final String ID = "ID";
    public static final String FINISHED = "FINISHED";
    public static final String DESCRIPTION = "DESCRIPTION";

    @DatabaseField(generatedId = true, columnName = ID)
    private Integer id;
    @DatabaseField(columnName = FINISHED, canBeNull = false)
    private boolean finished;
    @DatabaseField(columnName = DESCRIPTION, canBeNull = false)
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
