package com.example.guia8;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtEntrada;
    TextView txtSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnigual = findViewById(R.id.btnigual);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnDEL = findViewById(R.id.btnDEL);
        Button btnmas = findViewById(R.id.btnmas);
        Button btnmenos = findViewById(R.id.btnmenos);
        Button btnx = findViewById(R.id.btnx);
        Button btndivision = findViewById(R.id.btndivision);
        Button btnparent1= findViewById(R.id.btnparent1);
        Button btnparent2 = findViewById(R.id.btnparent2);
        Button btnpointer = findViewById(R.id.btnpoint);

        txtEntrada = findViewById(R.id.txtEntrada);
        txtSalida  = findViewById(R.id.txtSalida);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btndivision.setOnClickListener(this);
        btnx.setOnClickListener(this);
        btnmas.setOnClickListener(this);
        btnmenos.setOnClickListener(this);
        btnigual.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnDEL.setOnClickListener(this);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            btnpointer.setOnClickListener(this);
            btnparent1.setOnClickListener(this);
            btnparent2.setOnClickListener(this);

        }

    }

    @Override
    public void onClick(View view) {
        StringBuilder entrada = new StringBuilder();
        entrada.append(txtEntrada.getText().toString());
        switch (view.getId()){
            case R.id.btn0:
                entrada.append(0);
                break;
            case R.id.btn1:
                entrada.append(1);
                break;
            case R.id.btn2:
                entrada.append(2);
                break;
            case R.id.btn3:
                entrada.append(3);
                break;
            case R.id.btn4:
                entrada.append(4);
                break;
            case R.id.btn5:
                entrada.append(5);
                break;
            case R.id.btn6:
                entrada.append(6);
                break;
            case R.id.btn7:
                entrada.append(7);
                break;
            case R.id.btn8:
                entrada.append(8);
                break;
            case R.id.btn9:
                entrada.append(9);
                break;
            case R.id.btnDEL:
                if (entrada.length() > 0) {
                    entrada.deleteCharAt(entrada.length() - 1);
                }
                break;
            case R.id.btnAC:
                entrada.delete(0,entrada.length());
                txtSalida.setText("");
                break;
            case R.id.btnmas:
                entrada.append("+");
                break;
            case R.id.btnmenos:
                entrada.append("-");
                break;
            case R.id.btnx:
                entrada.append("*");
                break;
            case R.id.btndivision:
                entrada.append("/");
                break;
            case R.id.btnparent1:
                entrada.append("(");
                break;
            case R.id.btnparent2:
                entrada.append(")");
                break;
            case R.id.btnpoint:
                entrada.append(".");
                break;
            case R.id.btnigual:
                Expression e = new ExpressionBuilder(entrada.toString()).build();
                txtSalida.setText(String.valueOf(e.evaluate()));
                break;
            default:
                break;
        }
        txtEntrada.setText(entrada.toString());
    }
}