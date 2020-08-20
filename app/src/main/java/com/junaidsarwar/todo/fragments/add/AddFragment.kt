package com.junaidsarwar.todo.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.junaidsarwar.todo.R
import com.junaidsarwar.todo.data.ToDoViewModel
import com.junaidsarwar.todo.data.models.Priority
import com.junaidsarwar.todo.data.models.ToDoData
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {
    private val TodoViewModel: ToDoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            insertDataToDB()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDB() {
        val title = title_et.text.toString()
        val priority = priority_sp.selectedItem.toString()
        val description = description_et.text.toString()
        val validate = validateInput(title, description)
        if (validate) {
            val newData = ToDoData(
                0,
                title,
                getPriority(priority),
                description
            )
            TodoViewModel.insertData(newData)
        }
    }

    private fun getPriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> {
                Priority.HIGH
            }
            "Medium Priority" -> {
                Priority.MEDIUM
            }
            else -> {
                Priority.LOW
            }

        }

    }

    private fun validateInput(title: String, description: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }
}