package com.zarza.flores.diego.israel;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class DivisionActivity extends AppCompatActivity {

    private EditText editTextX;
    private EditText editTextY;
    private EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        editTextX = findViewById(R.id.editTextNumberX);
        editTextY = findViewById(R.id.editTextNumberY);
        editTextTotal = findViewById(R.id.editTextNumberTotal);
        editTextX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    realizaOperacion();
                }
            }
        });
        editTextY.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    realizaOperacion();
                }
            }
        });
    }

    private void realizaOperacion(){
        double total = 0;
        if(editTextX.getText().toString() != null){
            if( isEntero(editTextX.getText().toString())){
                total += Double.parseDouble(editTextX.getText().toString());
            }
        }

        if(editTextY.getText().toString() != null){
            if( isEntero(editTextY.getText().toString()) && !editTextY.getText().toString().equals("0")){
                total /= Double.parseDouble(editTextY.getText().toString());
            }
        }

        editTextTotal.setText(String.valueOf(total));
        editTextTotal.setEnabled(false);
    }

    private int getEntero(String entero){
        try{
            return Integer.parseInt(entero);
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return 0;
    }

    private boolean isEntero(String entero){
        try{
            if(entero == null || entero.length() == 0){
                return false;
            }
            Integer.parseInt(entero);
            return true;
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        return false;
    }

}
