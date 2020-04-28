package com.example.monitoringandfeedback7.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.monitoringandfeedback7.R;
import com.example.monitoringandfeedback7.data.User;
import com.example.monitoringandfeedback7.viewmodel.UserViewModel;

public class UserInputFragment extends Fragment {
    private UserViewModel userViewModel;
    private LiveData<User> userLiveData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(
                getActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
        ).get(UserViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_userinput, container, false);
        final EditText userName = v.findViewById(R.id.user_name);
        final EditText userEmail = v.findViewById(R.id.user_email);
        userViewModel.userInserted().observe(this, user -> {
            Toast.makeText(getContext(), "User Added: " + user.getEmail(), Toast.LENGTH_SHORT).show();
        });
        v.findViewById(R.id.submit).setOnClickListener((view) -> {
            User u = new User(userName.getText().toString(), userEmail.getText().toString());
            userViewModel.setUser(u);
        });
        return v;
    }
}
