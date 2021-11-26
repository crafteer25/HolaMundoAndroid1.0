package com.zarza.flores.diego.israel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonSuma;
    private Button buttonResta;
    private Button buttonMultiplicacion;
    private Button buttonDivision;
    private Button buttonHipotenusa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSuma = findViewById(R.id.buttonSuma);
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirSuma();
            }
        });
        buttonResta = findViewById(R.id.buttonResta);
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirResta();
            }
        });
        buttonMultiplicacion = findViewById(R.id.buttonMultiplicacion);
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMultiplicacion();
            }
        });
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDivision();
            }
        });
        buttonHipotenusa = findViewById(R.id.buttonHipotenusa);
        buttonHipotenusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirHipotenusa();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void abrirSuma(){
        Intent Intent = new Intent(this, SumaActivity.class);
        startActivity(Intent);
    }

    private void abrirResta(){
        Intent Intent = new Intent(this, RestaActivity.class);
        startActivity(Intent);
    }

    private void abrirMultiplicacion(){
        Intent Intent = new Intent(this, MultiplicacionActivity.class);
        startActivity(Intent);
        System.out.println("ctm");
    }

    private void abrirDivision(){
        Intent Intent = new Intent(this, DivisionActivity.class);
        startActivity(Intent);
    }

    private void abrirHipotenusa(){
        Intent Intent = new Intent(this, HipotenusaActivity.class);
        startActivity(Intent);
    }
}
