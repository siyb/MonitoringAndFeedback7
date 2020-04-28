package com.example.monitoringandfeedback7.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.monitoringandfeedback7.MUFApplication;
import com.example.monitoringandfeedback7.MUFDatabase;

public abstract class BaseViewModel extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MUFDatabase getDatabase() {
        return ((MUFApplication) getApplication()).getDatabase();
    }
}
