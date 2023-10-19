package com.gaurav.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Struct;

public class MainActivity extends AppCompatActivity {

    String[]  array = {"celcius","farenheit","kelvin"};
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView2;
    ArrayAdapter<String> arrayAdapter;

    TextView result;
    EditText input;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView2);
        result = findViewById(R.id.result);
        input = findViewById(R.id.input);
        btn = findViewById(R.id.button);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.dropdown_item,array);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity.this, "item"+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity.this, "item"+item, Toast.LENGTH_SHORT).show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(autoCompleteTextView.getText().toString().equals("celcius") && autoCompleteTextView2.getText().toString().equals("celcius")){
                result.setText(input.getText());
            }else if(autoCompleteTextView.getText().toString().equals("celcius") && autoCompleteTextView2.getText().toString().equals("farenheit")){
//                (°C × 9/5) + 32 = °F
                String val = input.getText().toString();
                int res = Integer.parseInt(val);
                float resu = (res*9/5)+32;
                result.setText((String.valueOf(resu)));
            }else if(autoCompleteTextView.getText().toString().equals("celcius") && autoCompleteTextView2.getText().toString().equals("kelvin")){
//                °C + 273.15 = K
                int res = Integer.parseInt(input.getText().toString());
                double resu = (res + 273.15);
                result.setText(String.valueOf(resu));

            }else if(autoCompleteTextView.getText().toString().equals("farenheit") && autoCompleteTextView2.getText().toString().equals("celcius")){
//                (°F − 32) × 5/9 = °C
                int res = Integer.parseInt(input.getText().toString());
                double resu = (res-32)*5/9;
                result.setText(String.valueOf(resu));
            }else if(autoCompleteTextView.getText().toString().equals("farenheit") && autoCompleteTextView2.getText().toString().equals("farenheit")){
                result.setText(input.getText());
            }else if(autoCompleteTextView.getText().toString().equals("farenheit") && autoCompleteTextView2.getText().toString().equals("kelvin")){
//                (°F − 32) × 5/9 + 273.15 = K

                int res = Integer.parseInt(input.getText().toString());
                double resu = (res-32)*5/9 +273.15;
                result.setText(String.valueOf(resu));
            }else if(autoCompleteTextView.getText().toString().equals("kelvin") && autoCompleteTextView2.getText().toString().equals("celcius")){
//             K − 273.15 = °C

                int res = Integer.parseInt(input.getText().toString());
                double resu = (res-273.15);
                result.setText(String.valueOf(resu));
            }else if(autoCompleteTextView.getText().toString().equals("kelvin") && autoCompleteTextView2.getText().toString().equals("farenheit")){
//            (K − 273.15) × 9/5 + 32 = °F

                int res = Integer.parseInt(input.getText().toString());
                double resu = (res-273.15)*9/5+32;
                result.setText(String.valueOf(resu));
            }else if(autoCompleteTextView.getText().toString().equals("kelvin") && autoCompleteTextView2.getText().toString().equals("kelvin")){

                result.setText(input.getText());
            }else{
                Toast.makeText(MainActivity.this, "Select appropriate measurement", Toast.LENGTH_SHORT).show();
            }

        }
        });

//
    }
}