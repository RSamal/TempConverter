package com.android.tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText text;
    private Button celc, far;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.temp_et);
        celc = (Button) findViewById(R.id.button);
        far = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);

        celc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call convertToCelcious()

                String editTextVal = text.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter a value",Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        double temp = Double.parseDouble(editTextVal);
                        double celResult = convertToCelcious(temp);
                        textView.setText(Double.toString(celResult));

                    } catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_LONG).show();
                    }





                }
            }
        });

        far.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call convertToFarenihite()
                String editTextVal = text.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter a value",Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        double temp = Double.parseDouble(editTextVal);
                        double farResult = convertToFarenhite(temp);
                        textView.setText(Double.toString(farResult));

                    } catch (NumberFormatException e){
                        Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_LONG).show();
                    }


                }

            }
        });
    }

    public double convertToCelcious(double far){
        return (far -32) * 5/9;
    }

    public  double convertToFarenhite(double cel){
        return (cel * 9/5)+32;
    }

}
