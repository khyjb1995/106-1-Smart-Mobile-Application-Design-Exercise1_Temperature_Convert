package com.example.khy_j.a410321171_exercise1_temperature_convert;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCtoF, btnCtoK, btnKtoF, btnKtoC, btnFtoC, btnFtoK;
    private TextView txtResult, txtPastResult;
    private String passrec, result;
    private EditText txtInput;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput=(EditText)findViewById(R.id.editText_Input);
        txtResult=(TextView)findViewById(R.id.textView_Result);
        txtPastResult=(TextView)findViewById(R.id.textView_PastResult);
        btnCtoF=(Button)findViewById(R.id.btnCtoF);
        btnCtoK=(Button)findViewById(R.id.btnCtoK);
        btnKtoF=(Button)findViewById(R.id.btnKtoF);
        btnKtoC=(Button)findViewById(R.id.btnKtoC);
        btnFtoC=(Button)findViewById(R.id.btnFtoC);
        btnFtoK=(Button)findViewById(R.id.btnFtoK);

        btnCtoF.setOnClickListener(myListener);
        btnCtoK.setOnClickListener(myListener);
        btnKtoC.setOnClickListener(myListener);
        btnKtoF.setOnClickListener(myListener);
        btnFtoK.setOnClickListener(myListener);
        btnFtoC.setOnClickListener(myListener);

        txtPastResult.setText("");
        txtResult.setText("");
        txtInput.setText("0");
    }
    private Button.OnClickListener myListener =new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            Double s = Double.parseDouble(txtInput.getText().toString()) ;
            if(txtResult.getText().toString() != "")
            {
                txtPastResult.setText(passrec + "\n" + txtPastResult.getText().toString());
            }
            passrec = s.toString();
            switch (view.getId()) {
                case R.id.btnCtoF: {
                    s = s * 1.8 + 32;
                    result = "°C  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + "°F";
                    break;
                }
                case R.id.btnCtoK: {
                    s = s + 273.15;
                    result = "°C  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + " K";
                    break;
                }
                case R.id.btnFtoC:{
                    s = (s - 32) / 1.8;
                    result = "°F  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + "°C";
                    break;
                }
                case R.id.btnFtoK:{
                    s = ((s - 32) / 1.8) + 273.15;
                    result = "°F  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + " K";
                    break;
                }
                case R.id.btnKtoC:{
                    s = s - 273.15;
                    result = " K  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + "°C";
                    break;
                }
                case R.id.btnKtoF: {
                    s = (s - 273.15) * 1.8 + 32;
                    result = " K  to  " + Double.valueOf(Double.parseDouble(new DecimalFormat(".00").format(s))).toString() + "°F";
                    break;
                }
            }
            txtResult.setText(result);
            passrec = passrec + result;
        }
    };
}
