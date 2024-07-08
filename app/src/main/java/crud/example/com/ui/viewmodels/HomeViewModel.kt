package crud.example.com.ui.viewmodels

import androidx.lifecycle.ViewModel
import crud.example.com.database.entities.ToDoEntity
import crud.example.com.models.TodoModel
import crud.example.com.repositories.TodoRepository
import java.util.UUID

class HomeViewModel(
    private val repository: TodoRepository
) : ViewModel() {

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