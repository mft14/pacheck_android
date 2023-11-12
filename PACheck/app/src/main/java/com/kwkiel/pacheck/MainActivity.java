package com.kwkiel.pacheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tf_p1, tf_p2, tf_a1, tf_a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf_p1 = (EditText) findViewById(R.id.tfPrice1);
        tf_p2 = (EditText) findViewById(R.id.tfPrice2);
        tf_a1 = (EditText) findViewById(R.id.tfAmount1);
        tf_a2 = (EditText) findViewById(R.id.tfAmount2);

        TextView tvResult = findViewById(R.id.lblResult);
        TextView tvSave = findViewById(R.id.lblSave);
        /////////////////////////////////////////////////////////////////

        //Calculate Button
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If one field is empty, make a toast message hint
                if(     tf_a1.getText().toString().equals("") ||
                        tf_a2.getText().toString().equals("") ||
                        tf_p1.getText().toString().equals("") ||
                        tf_p2.getText().toString().equals("") ) {

                    Toast.makeText(MainActivity.this, "Please put in some numbers", Toast.LENGTH_SHORT).show();
                } else { //Else go on

                    DecimalFormat df = new DecimalFormat("0.##"); //Decimal Format
                    //Creating variables
                    double res1, res2, save1, save2;
                    //Get the numbers and convert them
                    double p1 = Double.valueOf(tf_p1.getText().toString());
                    double p2 = Double.valueOf(tf_p2.getText().toString());
                    double a1 = Double.valueOf(tf_a1.getText().toString());
                    double a2 = Double.valueOf(tf_a2.getText().toString());

                    //basic calculation
                    res1 = p1 / a1;
                    res2 = p2 / a2;

                    //Formula of how to save
                    save1 = (res2 - res1) * a1;
                    save2 = (res1 - res2) * a2;

                    System.out.println(save1);
                    System.out.println(save2);

                    //Here are the results
                    if (res1 < res2) { //Product 1 cheaper
                        tvResult.setText("Product 1 is cheaper");
                        tvSave.setText("You save " + df.format(save1) + " €/$");
                    } else if (res1 == res2) { //Both equal
                        tvResult.setText("Both products have the same price");
                        tvSave.setText("");
                    } else { //Product 2 cheaper
                        tvResult.setText("Product 2 is cheaper");
                        tvSave.setText("You save " + df.format(save2) + " €/$");
                    }

                } //else end
                //Todo: Do stuff
            }
        });

        //Reset everything Button
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tf_p1.setText("1");
                tf_p2.setText("1");
                tf_a1.setText("1");
                tf_a2.setText("1");

                tvResult.setText("How much are you saving today?");
                tvSave.setText("");
            }
        });

    }

}