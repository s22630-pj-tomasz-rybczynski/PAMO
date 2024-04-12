package com.example.zjazd2.ui.notifications;

import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {
    public float calculateCalories(float weight, float height, int age, boolean isMale) {
        float bmr;
        if (isMale) {
            bmr = 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
        } else {
            bmr = 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        }
        return bmr * 1.2f; // assuming little to no exercise
    }
}