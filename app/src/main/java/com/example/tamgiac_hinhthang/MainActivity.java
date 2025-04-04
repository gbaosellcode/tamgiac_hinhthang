package com.example.tamgiac_hinhthang; // Thay đổi package name cho khớp với dự án

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tamgiac_hinhthang.R; // Import R từ package đúng

public class MainActivity extends AppCompatActivity {

    private EditText triangleBase, triangleHeight;
    private EditText trapezoidBase1, trapezoidBase2, trapezoidHeight;
    private TextView triangleResult, trapezoidResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Triangle components
        triangleBase = findViewById(R.id.triangleBase);
        triangleHeight = findViewById(R.id.triangleHeight);
        triangleResult = findViewById(R.id.triangleResult);

        // Initialize Trapezoid components
        trapezoidBase1 = findViewById(R.id.trapezoidBase1);
        trapezoidBase2 = findViewById(R.id.trapezoidBase2);
        trapezoidHeight = findViewById(R.id.trapezoidHeight);
        trapezoidResult = findViewById(R.id.trapezoidResult);

        // Add TextWatchers
        setupTriangleWatcher();
        setupTrapezoidWatcher();
    }

    private void setupTriangleWatcher() {
        TextWatcher triangleWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateTriangleArea();
            }
        };

        triangleBase.addTextChangedListener(triangleWatcher);
        triangleHeight.addTextChangedListener(triangleWatcher);
    }

    private void setupTrapezoidWatcher() {
        TextWatcher trapezoidWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateTrapezoidArea();
            }
        };

        trapezoidBase1.addTextChangedListener(trapezoidWatcher);
        trapezoidBase2.addTextChangedListener(trapezoidWatcher);
        trapezoidHeight.addTextChangedListener(trapezoidWatcher);
    }

    private void calculateTriangleArea() {
        try {
            double base = triangleBase.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(triangleBase.getText().toString());
            double height = triangleHeight.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(triangleHeight.getText().toString());
            double area = 0.5 * base * height;
            triangleResult.setText(String.format("Kết quả: %.2f đơn vị", area)); // Thay "Result" bằng "Kết quả" cho đồng bộ
        } catch (NumberFormatException e) {
            triangleResult.setText("Kết quả: Dữ liệu không hợp lệ"); // Dịch sang tiếng Việt
        }
    }

    private void calculateTrapezoidArea() {
        try {
            double base1 = trapezoidBase1.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(trapezoidBase1.getText().toString());
            double base2 = trapezoidBase2.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(trapezoidBase2.getText().toString());
            double height = trapezoidHeight.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(trapezoidHeight.getText().toString());
            double area = 0.5 * (base1 + base2) * height;
            trapezoidResult.setText(String.format("Kết quả: %.2f đơn vị", area)); // Thay "Result" bằng "Kết quả"
        } catch (NumberFormatException e) {
            trapezoidResult.setText("Kết quả: Dữ liệu không hợp lệ"); // Dịch sang tiếng Việt
        }
    }
}