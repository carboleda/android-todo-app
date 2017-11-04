package co.devhack.todoapp.repository.impl;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import co.devhack.todoapp.helpers.DatabaseHelper;
import co.devhack.todoapp.helpers.RetrofitHelper;
import co.devhack.todoapp.model.TodoItem;
import co.devhack.todoapp.repository.TodoRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by krlosf on 28/08/17.
 */

public class TodoRepositoryRest implements TodoRepository {

    public interface TodoService {
        @GET("todos")
        Call<List<TodoItem>> listTodos();
    }

    @Override
    public int create(TodoItem todoItem) throws SQLException {
        return 0;
    }

    @Override
    public int update(TodoItem todoItem) throws SQLException {
        return 0;
    }

    @Override
    public List<TodoItem> getAll() throws SQLException {
        return null;
    }

    @Override
    public void getAll(final co.devhack.todoapp.helpers.Callback callback) throws SQLException {
        Retrofit retrofit = RetrofitHelper.getInstance();
        TodoService todoService = retrofit.create(TodoService.class);
        todoService.listTodos().enqueue(new Callback<List<TodoItem>>() {
            @Override
            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {
                callback.finish(null, response.body());
            }

            @Override
            public void onFailure(Call<List<TodoItem>> call, Throwable t) {
                callback.finish(t, null);
            }
        });
    }
}
