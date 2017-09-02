package co.devhack.todoapp.repository;

import java.util.ArrayList;
import java.util.List;

import co.devhack.todoapp.model.TodoItem;

/**
 * Created by krlosf on 28/08/17.
 */

public class Storage {
    public static final List<TodoItem> TODO_ITEMS = new ArrayList<>(0);

    static {
        TODO_ITEMS.add(new TodoItem(true, "Crear eventos para finalizar items"));
        TODO_ITEMS.add(new TodoItem(false, "Implementar pantalla para crear nuevos items"));
    }
}
