package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R.*
import com.example.todolist.ui.theme.ToDoAdapter
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.ui.theme.Todo

class MainActivity : ComponentActivity() {

    private lateinit var todoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        todoAdapter = ToDoAdapter(mutableListOf())


        val rvTodoItems : RecyclerView = findViewById(id.rvTodoItems)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo : Button = findViewById(R.id.btnAddTodo)

        val etTodoTitle : EditText = findViewById(R.id.etTodoTitle)
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        val btnDeleteDoneTools : Button = findViewById(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTools.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}

