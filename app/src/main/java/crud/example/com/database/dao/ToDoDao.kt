package crud.example.com.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import crud.example.com.database.entities.tb_todo_list
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM tb_todo_list")
    fun findAll(): Flow<List<tb_todo_list>>

    @Query("SELECT * FROM tb_todo_list WHERE id = :id")
    fun getById(id: String): Flow<tb_todo_list>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: tb_todo_list)

    @Query("DELETE FROM tb_todo_list WHERE id = :id")
    suspend fun delete(id: String)

    @Query("DELETE FROM tb_todo_list")
    suspend fun deleteAll()
}

// Responsavel por acessar o banco de dados e falar os comportamentos do banco de dados