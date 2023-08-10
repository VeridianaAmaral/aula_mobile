package com.example.veridianameuamor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btSomar , btSubtrair, btDividir, btMultiplicar, btLimpar;

    TextView resultado;

    EditText edNum1;

    EditText edNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSomar = findViewById(R.id.btSomar);
        btSubtrair = findViewById(R.id.btSubtrair);
        btDividir = findViewById(R.id.btDividir);
        btMultiplicar = findViewById(R.id.btMultiplicar);
        edNum1 = findViewById(R.id.editText1);
        edNum2 = findViewById(R.id.editText2);
        resultado = findViewById(R.id.resultado);
        btLimpar = findViewById(R.id.btLimpar);

        btMultiplicar.setOnClickListener(this);

        btDividir.setOnClickListener(this);

        btSubtrair.setOnClickListener(this);

        btSomar.setOnClickListener(this);

        btLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double result = 0;
        double n1 = Double.parseDouble(edNum1.getText().toString());
        double n2 = Double.parseDouble(edNum2.getText().toString());

        if(edNum1.getText().toString().trim().equals("")){
            edNum1.setError("Preencha!");
        }else if(edNum2.getText().toString().trim().equals("")){
            edNum2.setError("Preencha!");
        }else if (edNum2.getText().toString().trim().equals("") && edNum1.getText().toString().trim().equals("")){
            edNum1.setError("Preencha!");
            edNum2.setError("Preencha!");
        }else{
            switch (view.getId()){
                case R.id.btSomar:
                    result = n1+n2;
                    break;
                case R.id.btSubtrair:
                    result = n1-n2;
                    break;
                case R.id.btDividir:
                    if(Integer.parseInt(edNum2.getText().toString()) == 0){
                        edNum2.setError("Não pode zero");
                    }
                    result = n1/n2;
                    break;
                case R.id.btMultiplicar:
                    result = n1*n2;
                    break;
                case R.id.btLimpar:
                    edNum1.setText("");
                    edNum2.setText("");
                    resultado.setText("Resultado");
            }
            resultado.setText(Double.toString(result));
        }
    }
}
