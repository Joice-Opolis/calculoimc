package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button bCalcularImc;
    EditText idPeso;
    EditText idAltura;
    EditText idResultado;

    TextView idTipoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bCalcularImc=findViewById(R.id.bCalcularImc);
        idPeso=findViewById(R.id.idPeso);
        idAltura=findViewById(R.id.idAltura);
        idResultado=findViewById(R.id.idResultado);
        idTipoImc=findViewById(R.id.idTipoImc);

        bCalcularImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valorAltura = idAltura.getText().toString();
                double idValorAltura = Double.parseDouble(valorAltura);

                String valorPeso = idPeso.getText().toString();
                double idValorPeso = Double.parseDouble(valorPeso);

                double idCalculoImc = idValorPeso/(idValorAltura*idValorAltura);

                DecimalFormat numDec = new DecimalFormat("0.00");

                idResultado.setText(String.valueOf(numDec.format(idCalculoImc)+"kg/m2"));

                if (idCalculoImc<18.5){
                    idTipoImc.setText("Magreza");
                } else if (idCalculoImc>=18.5 & idCalculoImc<=24.9) {
                    idTipoImc.setText("Normal");
                } else if (idCalculoImc>=25.0 & idCalculoImc<=29.9) {
                    idTipoImc.setText("Sobrepeso");
                    
                } else if (idCalculoImc>=30.0 & idCalculoImc<=39.9) {
                    idTipoImc.setText("Obesidade");
                    
                }
                else {
                    idTipoImc.setText("Obesidade Grave");
                }
            }
        });
    }
}