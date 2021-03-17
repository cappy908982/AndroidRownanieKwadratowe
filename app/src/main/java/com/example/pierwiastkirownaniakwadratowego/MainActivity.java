package com.example.pierwiastkirownaniakwadratowego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    double a,b,c,x1,x2,x0,delta, pierwiastekDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText a=(EditText) findViewById(R.id.a);
        EditText b=(EditText) findViewById(R.id.b);
        EditText c=(EditText) findViewById(R.id.c);
        Button button =(Button) findViewById(R.id.button);
        TextView pierwiastek1=(TextView) findViewById(R.id.textView5);
        TextView pierwiastek2=(TextView) findViewById(R.id.textView6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((a.getText().length()>0)&&(b.getText().length()>0)&&(c.getText().length()>0))
                {
                    if((Double.parseDouble(a.getText().toString())==0)&&(Double.parseDouble(b.getText().toString())==0)&&(Double.parseDouble(c.getText().toString())==0))
                    {
                        pierwiastek1.setText("Wszystkie liczby nie mogą być zerami.");
                        pierwiastek2.setText("Spróbuj ponownie");
                    }
                    else
                    {
                        delta=(Double.parseDouble(b.getText().toString()))*(Double.parseDouble(b.getText().toString()))-4*(Double.parseDouble(a.getText().toString()))*(Double.parseDouble(c.getText().toString()));
                        if(delta>0)
                        {
                            pierwiastekDelta=sqrt(delta);
                            x1=(-(Double.parseDouble(b.getText().toString()))-pierwiastekDelta)/(2*(Double.parseDouble(a.getText().toString())));
                            x2=(-(Double.parseDouble(b.getText().toString()))+pierwiastekDelta)/(2*(Double.parseDouble(a.getText().toString())));
                            pierwiastek1.setText(x1+"");
                            pierwiastek2.setText(x2+"");
                        }
                        else if(delta==0)
                        {
                            x1=(-(Double.parseDouble(b.getText().toString())))/2*(Double.parseDouble(a.getText().toString()));
                            pierwiastek1.setText(x1+"");
                            pierwiastek2.setText("Brak drugiego pierwiastka.");
                        }
                        else if(delta<0)
                        {
                            pierwiastek1.setText("Brak pierwszego pierwiastka.");
                            pierwiastek2.setText("Brak drugiego pierwiastka.");
                        }
                    }
                }
                else
                {
                    pierwiastek1.setText("Wszystkie pola formularza muszą być wypełnione.");
                    pierwiastek2.setText("Spróbuj ponownie");
                }
            }
        });
    }
}