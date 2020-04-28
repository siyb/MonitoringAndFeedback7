package com.example.monitoringandfeedback7;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.monitoringandfeedback7.dao.UserDao;
import com.example.monitoringandfeedback7.data.User;

@Database(entities = {User.class}, version = 1)
public abstract class MUFDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
