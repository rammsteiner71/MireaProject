package ru.mirea.kachalov.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class nav_calculator extends Fragment {
    private EditText num1;
    private EditText num2;
    private TextView result;

    public nav_calculator() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nav_calculator, container, false);

        Button sum = v.findViewById(R.id.sum);
        sum.setOnClickListener(view -> {
            num1 = v.findViewById(R.id.num);
            float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
            num2 = v.findViewById(R.id.num2);
            float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
            result = v.findViewById(R.id.textResult);
            float r = fnum1 + fnum2;
            result.setText(String.valueOf(r));
        });

        Button subtraction = v.findViewById(R.id.subtraction);
        subtraction.setOnClickListener(view -> {
            num1 = v.findViewById(R.id.num);
            float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
            num2 = v.findViewById(R.id.num2);
            float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
            result = v.findViewById(R.id.textResult);
            float r = fnum1 - fnum2;
            result.setText(String.valueOf(r));
        });

        Button multiply = v.findViewById(R.id.multiply);
        multiply.setOnClickListener(view -> {
            num1 = v.findViewById(R.id.num);
            float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
            num2 = v.findViewById(R.id.num2);
            float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
            result = v.findViewById(R.id.textResult);
            float r = fnum1 * fnum2;
            result.setText(String.valueOf(r));
        });

        Button del = v.findViewById(R.id.del);
        del.setOnClickListener(view -> {
            num1 = v.findViewById(R.id.num);
            float fnum1 = Float.parseFloat(String.valueOf(num1.getText()));
            num2 = v.findViewById(R.id.num2);
            float fnum2 = Float.parseFloat(String.valueOf(num2.getText()));
            result = v.findViewById(R.id.textResult);
            float r = fnum1 / fnum2;
            result.setText(String.valueOf(r));
        });
        return v;
    }
}