package com.teamnexters.eyelong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamnexters.eyelong.db.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getUserAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE name = :userName")
    fun getUserByUserName(userName: String): LiveData<List<User>>
}