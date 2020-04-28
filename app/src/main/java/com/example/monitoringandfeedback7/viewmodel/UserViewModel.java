package com.example.monitoringandfeedback7.viewmodel;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.monitoringandfeedback7.data.User;

import java.util.concurrent.atomic.AtomicBoolean;


public class UserViewModel extends BaseViewModel {
    private Handler handler = new Handler(Looper.getMainLooper());
    private UserLiveData userLiveData = new UserLiveData();

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> setUser(User user) {
        userLiveData.insertUser(user);
        return userLiveData;
    }

    public LiveData<User> getUser() {
        return getDatabase().getUserDao().getUser();
    }

    public LiveData<User> userInserted() {
        return userLiveData;
    }

    public class UserLiveData extends LiveData<User> {
        private AtomicBoolean active = new AtomicBoolean();

        void insertUser(User user) {
            System.out.println(user.getEmail());
            Runnable r = () -> {
                getDatabase().getUserDao().insert(user);
                if (active.get()) {
                    handler.post(() -> {
                        System.out.println("USERX"+user.getEmail());
                        setValue(user);
                    });
                }
            };
            Thread t = new Thread(r);
            t.start();
        }

        @Override
        protected void onActive() {
            active.set(true);
        }

        @Override
        protected void onInactive() {
            active.set(false);
        }
    }
}
