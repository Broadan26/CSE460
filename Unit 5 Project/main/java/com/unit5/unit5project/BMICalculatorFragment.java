package com.unit5.unit5project;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class BMICalculatorFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bmi_calc_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText weightText = (EditText) view.getRootView().findViewById(R.id.weightNum); //Make text objects
                EditText heightText = (EditText) view.getRootView().findViewById(R.id.heightNum);
                TextView bmitext = (TextView) view.getRootView().findViewById(R.id.bmi_score_label);
                TextView messageL = (TextView) view.getRootView().findViewById(R.id.messageLabel);

                int weight = Integer.parseInt(weightText.getText().toString()); //Pull their values
                int height = Integer.parseInt(heightText.getText().toString());

                double BMI = calculateBMI(height, weight); //Calculate the BMI
                String message = detMessage(BMI); //Determine message
                String color = detColor(BMI); //Determine message color

                bmitext.setText(String.valueOf(BMI)); //Change text value
                messageL.setText(message);

                bmitext.setTextColor(Color.parseColor(color)); //Change text color
                messageL.setTextColor(Color.parseColor(color));

                bmitext.setVisibility(View.VISIBLE); //Change visibility
                messageL.setVisibility(View.VISIBLE);
            }
        });
    }

    /*Calculates the BMI for the user*/
    public double calculateBMI(int height, int weight)
    {
        double heightD = height;
        double weightD = weight;
        double val = ((weightD/(heightD * heightD)) * 703);
        return val;
    }

    /*Determines the message to send*/
    public String detMessage(double BMI)
    {
        String message = "";
        if(BMI < 18)
            message = "You are underweight";
        else if(BMI <25)
            message = "You are normal weight";
        else if(BMI < 30)
            message = "You are pre-obese";
        else
            message = "You are obese";
        return message;
    }

    /*Determines the color for the text to be*/
    public String detColor(double BMI)
    {
        String color = "";
        if(BMI < 18)
            color = "#FF0D26C8";
        else if(BMI <25)
            color = "#FF1C8C08";
        else if(BMI < 30)
            color = "#FF7010C5";
        else
            color = "#FFEF0A24";
        return color;
    }
}