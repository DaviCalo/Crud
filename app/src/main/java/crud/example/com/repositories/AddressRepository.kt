package crud.example.com.repositories

import crud.example.com.database.dao.ToDoDao
import crud.example.com.database.entities.tb_todo_list
import crud.example.com.models.TodoModel
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers.IO

class TodoRepository(private val dao: ToDoDao) {
    val allTodos get() = dao.findAll()

    fun getById(id: String){
        dao.getById(id)
    }

    suspend fun insert(todo: TodoModel) = withContext(IO) {
        dao.insert(todo.toEntity())
    }

    suspend fun delete(id: String) = withContext(IO){
        dao.delete(id)
    }

    suspend fun deleteAll() = withContext(IO){
        dao.deleteAll()
    }
}

fun TodoModel.toEntity() = tb_todo_list(
    id = this.id,
    title = this.title,
    description = this.description,
    data = this.data,
    time = this.time,
    status = this.status
)

//class TodoRepository(val retrofit: Retrofit) {
//
//}