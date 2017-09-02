package co.devhack.todoapp.view;

import android.graphics.Paint;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.devhack.todoapp.R;
import co.devhack.todoapp.model.TodoItem;

/**
 * Created by krlosf on 28/08/17.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoItemHolder> {
    public interface OnTodoFinishChange {
        void onTodoFinishChange(int position, boolean finished);
    }

    private List<TodoItem> dataSet;
    private OnTodoFinishChange onTodoFinishChange;

    public TodoListAdapter(List<TodoItem> dataSet, OnTodoFinishChange onTodoFinishChange) {
        super();
        this.dataSet = dataSet;
        this.onTodoFinishChange = onTodoFinishChange;
    }

    @Override
    public TodoListAdapter.TodoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_todo_item, parent, false);

        return new TodoItemHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoListAdapter.TodoItemHolder holder, int position) {
        TodoItem todoItem = dataSet.get(position);

        holder.cbFinished.setChecked(todoItem.isFinished());
        if(todoItem.isFinished()) {
            //holder.tvDescription.setText(Utilities.strikeText(todoItem.getDescription()));

            //https://android--code.blogspot.com.co/2015/05/android-textview-strikethrough.html
            holder.tvDescription.setPaintFlags(holder.tvDescription.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.tvDescription.setPaintFlags(holder.tvDescription.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.tvDescription.setText(todoItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class TodoItemHolder extends RecyclerView.ViewHolder {

        AppCompatCheckBox cbFinished;
        TextView tvDescription;

        public TodoItemHolder(View itemView) {
            super(itemView);

            cbFinished = (AppCompatCheckBox) itemView.findViewById(R.id.cbFinished);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);

            if(onTodoFinishChange != null) {
                cbFinished.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        onTodoFinishChange.onTodoFinishChange(position, cbFinished.isChecked());
                    }
                });
            }
        }
    }
}
