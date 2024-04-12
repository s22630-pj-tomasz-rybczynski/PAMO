package com.example.zjazd2.ui.dashboard;

import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.zjazd2.R;

public class DashboardViewModel extends ViewModel {

    public float calculateBMI(float weight, float height) {
        height = height / 100; // convert height to meters
        return weight / (height * height);
    }
}