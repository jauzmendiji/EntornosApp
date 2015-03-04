package com.example.ubuntu.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IMCActivity extends ActionBarActivity implements OnClickListener {

    EditText peso;
    EditText altura;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(this);

        peso = (EditText) findViewById(R.id.peso);
        altura = (EditText) findViewById(R.id.altura);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calcular:
                break;}

            if (peso.getText().toString().trim().length() == 0) {
                peso.requestFocus();

                Toast.makeText(IMCActivity.this,
                        "No te olvides de rellenar el peso", Toast.LENGTH_SHORT)
                        .show();
            } else {
                if (altura.getText().toString().trim().length() == 0) {
                    altura.requestFocus();

                    Toast.makeText(IMCActivity.this,
                            "No te olvides de rellenar la altura",
                            Toast.LENGTH_SHORT).show();
                } else {

                    float kg = Float.parseFloat(peso.getText().toString());
                    float cm = Float.parseFloat(altura.getText().toString());
                    float m = (cm / 100);
                    float bmi = (kg / (m * m));

                    if (bmi < 18.5) {
                        Toast.makeText(IMCActivity.this,
                                "Tu IMC es " + bmi + "\n" + "Estas delgado",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        if (bmi < 24.9) {
                            Toast.makeText(
                                    IMCActivity.this,
                                    "Tu IMC es " + bmi + "\n"
                                            + "Tu peso es normal",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            if (bmi < 29.9) {
                                Toast.makeText(
                                        IMCActivity.this,
                                        "Tu IMC es " + bmi + "\n"
                                                + "Tienes sobrepeso",
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                if (bmi > 30) {
                                    Toast.makeText(
                                            IMCActivity.this,
                                            "Tu IMC es " + bmi + "\n"
                                                    + "Padeces obesidad",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        }
                    }
                }
            }
        }




            @Override
            public boolean onCreateOptionsMenu (Menu menu){
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_imc, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected (MenuItem item){
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }

}