package com.example.myapplicationassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import model.EquationDa;


public class MainActivity extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;

    private Spinner spinnerTypeEq;
    private TextView formula;
    private TextView tx_res;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.EditA);
        editB = findViewById(R.id.EditB);
        editC = findViewById(R.id.EditC);
        spinnerTypeEq = findViewById(R.id.spinnerTypeEq);
        formula = findViewById(R.id.formula);
        tx_res = findViewById(R.id.tx_res);


        spinnerTypeEq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    formula.setText(getResources().getText(R.string.formula_ax_b));
                    editC.setVisibility(View.GONE);
                } else {
                    formula.setText(getResources().getText(R.string.formula_ax_2_bx_c));
                    editC.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void ptnData(View view) {
        EquationDa eq = new EquationDa();
        String s1 = editA.getText().toString();
        String s2 = editB.getText().toString();
        String s3 = editC.getText().toString();
        double[] arr;
        if (spinnerTypeEq.getSelectedItem().toString().equals("linear equation")) {
            arr = eq.getData(0, Double.parseDouble(s1), Double.parseDouble(s2));
        } else {
            arr = eq.getData(Double.parseDouble(s1), Double.parseDouble(s2), Double.parseDouble(s3));

        }
        if (arr[0] < 0) {
            tx_res.setText("mems less 0 then no roots");
            return;
        } else {
            String str1 = arr[0] + " ";
            String str2 = arr[1] + " ";
            String str3 = arr[2] + " ";

            tx_res.setText("Mems= " + str1 + "\n" + "Root1= " + str2 + "\n" + "Root2=" + str3);
        }
    }
}