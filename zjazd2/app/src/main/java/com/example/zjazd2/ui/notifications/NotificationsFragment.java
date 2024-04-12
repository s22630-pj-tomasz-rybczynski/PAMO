package com.example.zjazd2.ui.notifications;

// HomeFragment.java
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.zjazd2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText weightEditText = binding.weightEditText;
        EditText heightEditText = binding.heightEditText;
        EditText ageEditText = binding.ageEditText;
        RadioButton maleRadioButton = binding.maleRadioButton;
        TextView resultTextView = binding.resultTextView;

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateAndDisplayCalories(weightEditText, heightEditText, ageEditText, maleRadioButton, resultTextView);
            }
        };

        weightEditText.addTextChangedListener(textWatcher);
        heightEditText.addTextChangedListener(textWatcher);
        ageEditText.addTextChangedListener(textWatcher);
        maleRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> calculateAndDisplayCalories(weightEditText, heightEditText, ageEditText, maleRadioButton, resultTextView));

        return root;
    }

    private void calculateAndDisplayCalories(EditText weightEditText, EditText heightEditText, EditText ageEditText, RadioButton maleRadioButton, TextView resultTextView) {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();
        String ageString = ageEditText.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty() || ageString.isEmpty()) {
            resultTextView.setText("Please enter your weight, height, and age");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString);
        int age = Integer.parseInt(ageString);
        boolean isMale = maleRadioButton.isChecked();

        float calories = notificationsViewModel.calculateCalories(weight, height, age, isMale);

        String caloriesResult = String.format("Daily calorie intake: %.2f", calories);
        resultTextView.setText(caloriesResult);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}