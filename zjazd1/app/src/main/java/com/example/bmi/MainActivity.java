package com.example.bmi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightEditText, heightEditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        resultTextView = findViewById(R.id.resultTextView);

        weightEditText.addTextChangedListener(textWatcher);
        heightEditText.addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            calculateBMI();
        }
    };

    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            resultTextView.setText("Wprowadz wzrost i wage");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString) / 100; // convert height to meters

        float bmi = weight / (height * height);

        displayBMI(bmi);
    }

    private void displayBMI(float bmi) {
        String bmiResult = String.format("BMI: %.2f", bmi);
        resultTextView.setText(bmiResult);
    }
}
