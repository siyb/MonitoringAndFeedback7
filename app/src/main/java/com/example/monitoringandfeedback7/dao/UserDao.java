package com.example.monitoringandfeedback7.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.monitoringandfeedback7.data.User;

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM user WHERE email=:email")
    public abstract LiveData<User> getUserByEmail(String email);

    @Query("SELECT * FROM user")
    public abstract LiveData<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(User user);
}
