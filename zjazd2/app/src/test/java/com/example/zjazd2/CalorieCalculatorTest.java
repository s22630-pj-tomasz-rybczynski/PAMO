package com.example.zjazd2;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.zjazd2.ui.notifications.NotificationsViewModel;

public class CalorieCalculatorTest {
    NotificationsViewModel calculator = new NotificationsViewModel();

    @Test
    public void testCalculateCaloriesForMale() {
        float weight = 70; // 70 kg
        float height = 175; // 175 cm
        int age = 30; // 30 years
        boolean isMale = true;

        double expectedCalories = 2034.8004150390625; // kcal
        double actualCalories = calculator.calculateCalories(weight, height, age, isMale);

        assertEquals(expectedCalories, actualCalories, 0.01);
    }

    @Test
    public void testCalculateCaloriesForFemale() {
        float weight = 60; // 60 kg
        float height = 165; // 165 cm
        int age = 25; // 25 years
        boolean isMale = false;

        double expectedCalories = 1686.399658203125; // kcal
        double actualCalories = calculator.calculateCalories(weight, height, age, isMale);

        assertEquals(expectedCalories, actualCalories, 0.01);
    }
}
