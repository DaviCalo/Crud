package crud.example.com.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import crud.example.com.database.entities.ToDoEntity
import crud.example.com.models.TodoModel
import crud.example.com.repositories.TodoRepository
import java.util.UUID

class HomeViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    val allTodos get() = repository.allTodos.toString()

    var page: String by mutableIntStateOf("")

    page = allTodos

    suspend fun insert(
        title: String,
        description: String,
        data: Int,
        status: String
    ){
        repository.insert(
            TodoModel(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                data = data,
                status = status
            )
        )
    }
}