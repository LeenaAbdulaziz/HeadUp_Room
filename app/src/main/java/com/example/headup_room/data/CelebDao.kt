package com.example.headup_room.data

import androidx.room.*

@Dao
interface CelebDao {
    @Query("SELECT * FROM Celeberty ORDER BY name DESC")
    fun getAllUserInfo(): List<Celebrity>

    @Insert
    fun insertnote(n: Celebrity)
    @Update
    fun updateNote(celebrity: Celebrity)
    @Delete
    fun deleteNote(celebrity: Celebrity)

}