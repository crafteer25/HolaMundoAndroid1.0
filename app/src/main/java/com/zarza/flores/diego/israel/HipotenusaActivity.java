package com.zarza.flores.diego.israel;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class HipotenusaActivity extends AppCompatActivity {
    Button calcular;
    Button limpiar;
    EditText teC;
    EditText teB;
    TextView resultado;

    DecimalFormat formato = new DecimalFormat("#.00");

    String cateto_c;
    String cateto_b;
    String respuesta;
    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipotenusa);
        calcular = (Button) findViewById(R.id.calcular);
        limpiar = (Button) findViewById(R.id.btnLimpiar);
        teC = (EditText) findViewById(R.id.edtxtC);
        teB = (EditText) findViewById(R.id.edtxtB);
        resultado = (TextView) findViewById(R.id.txtResultado);

        limpiar.setEnabled(false);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cateto_b = teB.getText().toString();
                cateto_c = teC.getText().toString();

                if(cateto_c.length() == 0){ //Verificar si no hay nada escrito
                    dialog = new AlertDialog.Builder(HipotenusaActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Ingresar el valor del cateto menor 'c'");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            teC.requestFocus();
                        }
                    });
                    dialog.show();
                }else {
                    if (cateto_b.length() == 0) { //Verificar si no hay nada escrito
                        dialog = new AlertDialog.Builder(HipotenusaActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el valor del cateto mayor 'b'");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                teB.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        double c = Double.parseDouble(cateto_c);
                        double b = Double.parseDouble(cateto_b);
                        double r = Math.pow((Math.pow(c, 2.0) + Math.pow(b, 2.0)), 0.5);
                        respuesta = String.valueOf(formato.format(r));
                        if(r % 1.0 == 0.0){
                            respuesta = String.valueOf((int) r);
                        }
                        resultado.setText("La hipotenusa 'a' es:  " + respuesta);
                        limpiar.setEnabled(true);
                        calcular.setEnabled(false);
                    }
                }
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar_controles();
            }
        });
    }

    public void limpiar_controles(){
        teB.setText("");
        teC.setText("");
        resultado.setText("");
        teC.requestFocus();
        limpiar.setEnabled(false);
        calcular.setEnabled(true);
    }

}
