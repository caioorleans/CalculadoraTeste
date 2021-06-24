package com.example.calculadorateste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button btMod;
    EditText edTexto1;
    EditText edTexto2;
    TextView resultado;
    Spinner spinnerOperacao;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMod = (Button) findViewById(R.id.botaoCalcular);
        btMod.setOnClickListener( this );

        edTexto1 = (EditText) findViewById(R.id.editTextValor1);
        edTexto2 = (EditText) findViewById(R.id.editTextValor2);

        resultado = (TextView) findViewById(R.id.resultado);

        spinnerOperacao = (Spinner) findViewById(R.id.operacaoSpinner);
        spinnerOperacao.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operacoes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperacao.setAdapter(adapter);
    }

    @Override
    public void onClick(View view){
        if(view == btMod){
            String temp1 = edTexto1.getText().toString();
            double valor1=Double.parseDouble(temp1);

            String temp2 = edTexto2.getText().toString();
            double valor2=Double.parseDouble(temp2);

            double result = 0;

            switch(op){
                case "Adição":
                    result = valor1 + valor2;
                    break;
                case "subtração":
                    result = valor1 - valor2;
                    break;
                case "Multiplicação":
                    result = valor1 * valor2;
                    break;
                case "Divisão":
                    result = valor1/valor2;
                    break;
            }
            resultado.setText(Double.toString(result));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        op = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}