package com.shawn_wind.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  int number = 0;
    private  int result = 0;
    private  int operatorID;

    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  onNumberButtonClick(View view){
        Button button = (Button) view;
        number = number * 10 + Integer.parseInt(button.getText(). toString());
        show(number);
    }

    public void onOperatorButtonClick(View view){
        operatorID = view.getId();
        result = number;
        number = 0;
    }

    public void onEqualButtonClick(View view){
        switch (operatorID){
            case R.id.buttonAdditoin:
                result += number;
                break;

            case R.id.buttonSubtraction:
                result -= number;
                break;

            case R.id.buttonMaltiplication:
                result *= number;
                break;

            case  R.id.buttonDivision:
                result /= number;
                break;

            default:
                assert false;
                break;
        }

        number = 0;
        show(result);
    }

    public void onClearButtonClick(View view){
        number = 0;
        result = 0;
        operatorID = 0;
        show(number);
    }


    private  void show(int number){
        TextView resultView = (TextView) findViewById(R.id.display);
        resultView.setText(Integer.toString(number));

    }
}
