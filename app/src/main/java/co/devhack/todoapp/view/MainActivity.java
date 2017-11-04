package co.devhack.todoapp.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import co.devhack.todoapp.R;
import co.devhack.todoapp.model.TodoItem;
import co.devhack.todoapp.presenter.MainContract;
import co.devhack.todoapp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        View.OnClickListener, TodoListAdapter.OnTodoFinishChange {

    private MainContract.ActionListener mActionListener;
    private RecyclerView rvTodoList;
    private AppCompatEditText txtNewTodo;
    private FloatingActionButton btnCreateTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mActionListener = new MainPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvTodoList = (RecyclerView) findViewById(R.id.rvTodoList);
        rvTodoList.setLayoutManager(llm);
        List<TodoItem> lstTodoList = mActionListener.getTodoList();
        rvTodoList.setAdapter(new TodoListAdapter(lstTodoList, this));

        txtNewTodo = (AppCompatEditText) findViewById(R.id.txtNewTodo);
        btnCreateTodo = (FloatingActionButton) findViewById(R.id.btnCreateTodo);
        btnCreateTodo.setOnClickListener(this);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mActionListener.loadTodoList();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateTodo:
                //Sedicionar el nuevo item a la lista
                mActionListener.addTodo(txtNewTodo.getText().toString());
                break;
        }
    }

    @Override
    public void onTodoFinishChange(int position, boolean finished) {
        mActionListener.changeTodoStatus(position, finished);
    }

    @Override
    public void refreshTodoList() {
        //Notificar al adaptar del cambio en la lista
        rvTodoList.getAdapter().notifyDataSetChanged();

        //Mover el scroll hasta el ultimo item
        rvTodoList.scrollToPosition(rvTodoList.getAdapter().getItemCount()-1);

        //Limpiar caja de texto
        txtNewTodo.setText("");
    }

    @Override
    public void refreshTodoItem(int position) {
        rvTodoList.getAdapter().notifyItemChanged(position);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, R.string.error_loading_todos, Toast.LENGTH_LONG).show();
    }
}
