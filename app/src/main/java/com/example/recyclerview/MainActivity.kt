package com.example.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ItemTodoBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo(title = "Todo 1", isChecked = true),
            Todo(title = "Todo 2", isChecked = true),
            Todo(title = "Todo 3", isChecked = false),
            Todo(title = "Todo 4", isChecked = true),
            Todo(title = "Todo 5", isChecked = false),
            Todo(title = "Todo 6", isChecked = false),
            Todo(title = "Todo 7", isChecked = false),
            Todo(title = "Todo 8", isChecked = false),
            Todo(title = "Todo 9", isChecked = true)
        )

        val adapter = TodoAdapter(todos = todoList)

        binding.apply {
            rvTodos.adapter = adapter
            rvTodos.layoutManager = LinearLayoutManager(this@MainActivity)
            btnAdd.setOnClickListener {
                val title = tvTodo.text.toString()
                val todo = Todo(title = title, isChecked = false)
                todoList.add(todo)
//                adapter.notifyItemInserted(todoList.size - 1)
//                adapter.notifyDataSetChanged()
            }
        }
    }
}