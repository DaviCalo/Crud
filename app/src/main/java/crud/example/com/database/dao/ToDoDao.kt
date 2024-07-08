package crud.example.com.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import crud.example.com.database.entities.ToDoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM ToDoEntity")
    fun findAll(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM ToDoEntity WHERE id = :id")
    fun getById(id: String): Flow<ToDoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: ToDoEntity)

    @Query("DELETE FROM ToDoEntity WHERE id = :id")
    suspend fun delete(id: String)
}

// Responsavel por acessar o banco de dados e falar os comportamentos do banco de dados