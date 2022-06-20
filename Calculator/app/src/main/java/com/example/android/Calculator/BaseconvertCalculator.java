package com.example.android.Calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BaseconvertCalculator extends AppCompatActivity {
    private Button Number0,Number1,Number2,Number3,Number4,Number5,Number6,Number7,Number8,Number9,btnc,btnequal,Base2,Base10,to2,to8,to10,to16;
    private TextView result;
    private int ChoosingBase = 0;
    private int TargetBase=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseconvert_calculator);
        SetCallFunction();
        SetOnClick();
    }
    private void SetOnClick(){
        Number0.setOnClickListener(OnClick);
        Number1.setOnClickListener(OnClick);
        Number2.setOnClickListener(OnClick);
        Number3.setOnClickListener(OnClick);
        Number4.setOnClickListener(OnClick);
        Number5.setOnClickListener(OnClick);
        Number6.setOnClickListener(OnClick);
        Number7.setOnClickListener(OnClick);
        Number8.setOnClickListener(OnClick);
        Number9.setOnClickListener(OnClick);
        Base2.setOnClickListener(OnClick);
        Base10.setOnClickListener(OnClick);
        to2.setOnClickListener(OnClick);
        to8.setOnClickListener(OnClick);
        to10.setOnClickListener(OnClick);
        to16.setOnClickListener(OnClick);
        btnc.setOnClickListener(OnClick);
        btnequal.setOnClickListener(OnClick);
    }

    private void SetCallFunction(){
        Number0 = (Button) findViewById(R.id.number_zero_btn);
        Number1 = (Button) findViewById(R.id.number_one_btn);
        Number2 = (Button) findViewById(R.id.number_two_btn);
        Number3 = (Button) findViewById(R.id.number_three_btn);
        Number4 = (Button) findViewById(R.id.number_four_btn);
        Number5 = (Button) findViewById(R.id.number_five_btn);
        Number6 = (Button) findViewById(R.id.number_six_btn);
        Number7 = (Button) findViewById(R.id.number_seven_btn);
        Number8 = (Button) findViewById(R.id.number_eight_btn);
        Number9 = (Button) findViewById(R.id.number_nine_btn);
        btnc    = (Button) findViewById(R.id.operation_clear_btn);
        btnequal= (Button) findViewById(R.id.operation_equal_btn);
        Base2   = (Button) findViewById(R.id.base2_btn);
        Base10  = (Button) findViewById(R.id.base10_btn);
        to2     = (Button) findViewById(R.id.to2_btn);
        to8     = (Button) findViewById(R.id.to8_btn);
        to10    = (Button) findViewById(R.id.to10_btn);
        to16    = (Button) findViewById(R.id.to16_btn);
        result  = (TextView) findViewById(R.id.operation_result_text_view);
        result.setText("");
    }

    private Button.OnClickListener OnClick = new Button.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            String Current_number;
            Current_number = result.getText().toString();
            switch (view.getId())
            {
                case R.id.number_zero_btn       :NumberDisplay("0");break;
                case R.id.number_one_btn        :NumberDisplay("1");break;
                case R.id.number_two_btn        :NumberDisplay("2");break;
                case R.id.number_three_btn      :NumberDisplay("3");break;
                case R.id.number_four_btn       :NumberDisplay("4");break;
                case R.id.number_five_btn       :NumberDisplay("5");break;
                case R.id.number_six_btn        :NumberDisplay("6");break;
                case R.id.number_seven_btn      :NumberDisplay("7");break;
                case R.id.number_eight_btn      :NumberDisplay("8");break;
                case R.id.number_nine_btn       :NumberDisplay("9");break;
                case R.id.to2_btn               :BaseDisplay(" to (2)");TargetBase=2;break;
                case R.id.to8_btn               :BaseDisplay(" to (8)");TargetBase=8;break;
                case R.id.to10_btn              :BaseDisplay(" to (10)");TargetBase=10;break;
                case R.id.to16_btn              :BaseDisplay(" to (16)");TargetBase=16;break;
                case R.id.base2_btn             :ChoosingBase=2;BaseDisplay("  (2)");break;
                case R.id.base10_btn            :ChoosingBase=10;BaseDisplay("  (10)");break;
                case R.id.operation_clear_btn   :result.setText("");ChoosingBase=0;TargetBase=0;break;
                case R.id.operation_equal_btn   :if(ChoosingBase>0 && TargetBase>0){Calculate(result.getText().toString());}break;

            }
        }
    };



    private void NumberDisplay (String number)
    {
        String result_index;
        result_index = result.getText().toString();
        if("".equals(result_index) || "Same Base!".equals(result_index) || "Wrong Input!".equals(result_index))
        {
            result.setText(number);
        }
        else
        {
            result.setText(result_index + number);
        }
    }
    private void BaseDisplay(String base)
    {
        String result_index;
        result_index = result.getText().toString();
        if(ChoosingBase>0){
            result.setText(result_index + base);
        }


    }
    private void Calculate(String input) {
        String answer;
        String num = input.substring(0,input.indexOf(" "));
        for(int i =0;i<num.length();i++){
            if(Character.getNumericValue(num.charAt(i)) > 1 && ChoosingBase==2){
                result.setText("Wrong Input!");
                return;
            }
        }
        switch (TargetBase){
            case 2:
                if(ChoosingBase == 2){
                    result.setText("Same Base!");
                    return;
                }else{
                    num=Integer.toBinaryString(Integer.parseInt(num));
                }
                break;
            case 8:
                if(ChoosingBase == 2){
                    int temp = Integer.parseInt(num,2); //2轉成10
                    num=Integer.toOctalString(temp);
                }else{
                    num=Integer.toOctalString(Integer.parseInt(num));
                }
                break;
            case 10:
                if(ChoosingBase == 2){
                    num=String.valueOf(Integer.parseInt(num,2));
                }else{
                    result.setText("Same Base!");
                    return;
                }
                break;
            case 16:
                if(ChoosingBase == 2){
                    int temp = Integer.parseInt(num,2);
                    num=Integer.toHexString(temp);
                }else{
                    num=Integer.toHexString(Integer.parseInt(num));
                }
                break;
        }
        result.setText(num);

    }
}