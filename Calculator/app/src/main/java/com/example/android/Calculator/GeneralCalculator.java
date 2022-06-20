package com.example.android.Calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;

public class GeneralCalculator extends AppCompatActivity {
    /**
    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;
    */
    private Button Number0,Number1,Number2,Number3,Number4,Number5,Number6,Number7,Number8,Number9,btnadd,btnsub,btnmul,btndiv,btnpow,btndot,btnc,btnequal;
    private TextView result;
    int Calculate_index = 0;
    String NUM1 = "0", NUM2 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_calculator);
        SetCallFunction();
        SetOnClick();

        /**
        // Initialize the calculator class and all the views.
        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
         */
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
        btnadd.setOnClickListener(OnClick);
        btnsub.setOnClickListener(OnClick);
        btnmul.setOnClickListener(OnClick);
        btndiv.setOnClickListener(OnClick);
        btnpow.setOnClickListener(OnClick);
        btndot.setOnClickListener(OnClick);
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
        btnadd  = (Button) findViewById(R.id.operation_add_btn);
        btnsub  = (Button) findViewById(R.id.operation_sub_btn);
        btnmul  = (Button) findViewById(R.id.operation_mul_btn);
        btndiv  = (Button) findViewById(R.id.operation_div_btn);
        btnpow  = (Button) findViewById(R.id.operation_pow_btn);
        btndot  = (Button) findViewById(R.id.operation_dot_btn);
        btnc    = (Button) findViewById(R.id.operation_clear_btn);
        btnequal= (Button) findViewById(R.id.operation_equal_btn);
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
                case R.id.operation_add_btn     :Calculate(0,Current_number);break;
                case R.id.operation_sub_btn     :Calculate(1,Current_number);break;
                case R.id.operation_mul_btn     :Calculate(2,Current_number);break;
                case R.id.operation_div_btn     :Calculate(3,Current_number);break;
                case R.id.operation_pow_btn     :Calculate(4,Current_number);break;
                case R.id.operation_dot_btn     :NumberDisplay(".");break;
                case R.id.operation_clear_btn   :result.setText("");break;
                case R.id.operation_equal_btn   :Calculate(10,Current_number);break;
            }
        }
    };

    private void NumberDisplay (String number)
    {
        String result_index;
        result_index = result.getText().toString();
        if("".equals(result_index))
        {
            result.setText(number);
        }
        else
        {
            result.setText(result_index + number);
        }
    }

    private  void Calculate (int mode , String number_calculations){
        String Answer;
        double Answer_index;
        switch (mode)
        {
            case 0:
                NUM1 = number_calculations;
                Calculate_index = 0;
                result.setText("");
                break;
            case 1:
                NUM1 = number_calculations;
                Calculate_index = 1;
                result.setText("");
                break;
            case 2:
                NUM1 = number_calculations;
                Calculate_index = 2;
                result.setText("");
                break;
            case 3:
                NUM1 = number_calculations;
                Calculate_index = 3;
                result.setText("");
                break;
            case 4:
                NUM1 = number_calculations;
                Calculate_index = 4;
                result.setText("");
                break;

            case 10:
                NUM2 = result.getText().toString();
                double i = Double.valueOf(NUM1);
                double j = Double.valueOf(NUM2);
                switch (Calculate_index)
                {
                    case 0:
                        Answer_index = i + j;
                        Answer = Double.toString(Answer_index);
                        result.setText(Answer);
                        break;
                    case 1:
                        Answer_index = i - j;
                        Answer = Double.toString(Answer_index);
                        result.setText(Answer);
                        break;
                    case 2:
                        Answer_index = i * j;
                        Answer = Double.toString(Answer_index);
                        result.setText(Answer);
                        break;
                    case 3:
                        Answer_index = i / j;
                        Answer = Double.toString(Answer_index);
                        result.setText(Answer);
                        break;
                    case 4:
                        Answer_index = Math.pow(i,j);
                        Answer = Double.toString(Answer_index);
                        result.setText(Answer);
                        break;
                }
                break;
        }
    }
    /**

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }


    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onPow(View view) {
        compute(Calculator.Operator.POW);
    }


    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText(getString(R.string.computationError));
        }
    }


    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        mCalculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        mCalculator.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        mCalculator.mul(operandOne, operandTwo));
                break;
            case POW:
                result = String.valueOf(
                        mCalculator.pow(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResultTextView.setText(result);
    }


    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }


    private static String getOperandText(EditText operandEditText) {
        String operandText = operandEditText.getText().toString();
        if (TextUtils.isEmpty(operandText)) {
            throw new NumberFormatException("Operand cannot be empty!");
        }
        return operandText;
    }
     */
}