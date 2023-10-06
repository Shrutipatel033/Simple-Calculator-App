package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

public class Calculate extends AppCompatActivity {
    String input = "", output = "";
    TextView txtinput, txtoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        txtinput = findViewById(R.id.txtinput);
        txtoutput = findViewById(R.id.txtoutput);
    }

    public void InputButtonClick(View v) {
        Button btn = (Button) v;
        if(btn.getId()==R.id.btn_equal){
       // if (btn.getText()=="=") {
            Solve();
            txtinput.setText("");
        }
        else if(btn.getId()==R.id.btn_back){
            input=input.substring(0,input.length()-1);
            txtinput.setText(input);

        }
        else if(btn.getId()==R.id.btn_multiply){
            input += "*";
            txtinput.setText(input);

        }
        else if(btn.getId()==R.id.btn_plus|| btn.getId()==R.id.btn_minus
                || btn.getId()==R.id.btn_multiply ||btn.getId()==R.id.btn_divide || btn.getId()==R.id.btn_dot ) {
            char lastindexchar = input.charAt(input.length() - 1);
            if (lastindexchar != '+' && lastindexchar != '-' &&
                    lastindexchar != '*' && lastindexchar != '/' && lastindexchar != '.') {
                input += btn.getText();
                txtinput.setText(input);
            }
            txtoutput.setText("");
        }
        else if(btn.getId()==R.id.btn_cancel){
            input="";
            txtinput.setText("");
            txtoutput.setText("");
        }
         else {
            input += btn.getText();
            txtinput.setText(input);
            Solve();
        }
    }
    //method to solve the expression
    public void Solve(){
        Expression ex=new Expression(input);
          double result= ex.calculate();
          txtoutput.setText(String.valueOf(result));
    }
}


