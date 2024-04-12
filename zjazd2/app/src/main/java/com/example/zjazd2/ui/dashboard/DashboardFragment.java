package com.example.zjazd2.ui.dashboard;

// DashboardFragment.java
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.zjazd2.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardViewModel bmiCalculatorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bmiCalculatorViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText weightEditText = binding.weightEditText;
        EditText heightEditText = binding.heightEditText;
        TextView resultTextView = binding.resultTextView;

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateAndDisplayBMI(weightEditText, heightEditText, resultTextView);
            }
        };

        weightEditText.addTextChangedListener(textWatcher);
        heightEditText.addTextChangedListener(textWatcher);

        return root;
    }

    private void calculateAndDisplayBMI(EditText weightEditText, EditText heightEditText, TextView resultTextView) {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            resultTextView.setText("Wprowadz wzrost i wage");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString);

        float bmi = bmiCalculatorViewModel.calculateBMI(weight, height);

        String bmiResult = String.format("BMI: %.2f", bmi);
        resultTextView.setText(bmiResult);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}