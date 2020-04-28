package com.example.monitoringandfeedback7;

import android.app.Application;

import androidx.room.Room;

public class MUFApplication extends Application {
    private MUFDatabase mufDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mufDatabase = Room
                .databaseBuilder(this, MUFDatabase.class, "muf7")
                .build();
    }

    public MUFDatabase getDatabase() {
        return mufDatabase;
    }
}
