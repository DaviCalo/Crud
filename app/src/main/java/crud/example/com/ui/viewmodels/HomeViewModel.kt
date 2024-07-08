package crud.example.com.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import crud.example.com.models.TodoModel
import crud.example.com.repositories.TodoRepository
import java.util.UUID

class HomeViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    var selectedItem by mutableIntStateOf(2)


    suspend fun deleteAllCard(){
        repository.deleteAll()
    }

    val allTodos get() = repository.allTodos

    suspend fun insert(
        title: String,
        description: String,
        data: String,
        time: String,
        status: String
    ){
        repository.insert(
            TodoModel(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                data = data,
                time = time,
                status = status
            )
        )
    }
}