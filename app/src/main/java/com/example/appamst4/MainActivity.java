package com.example.appamst4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario, edtClave;
    private Button btnLogin, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias a los controles del diseño
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtClave = (EditText) findViewById(R.id.edtClave);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, formulario_registro.class);
        startActivity(intent);
    }

    public void login(View view) {
        Toast toast=Toast.makeText(getApplicationContext(),"Usted no cuenta con un usuario",Toast.LENGTH_SHORT);

        toast.show();
    }

    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){
            Log.d("mensaje","ingreso");

        }else if(v.getId() == R.id.btnRegistro) {
        }
    }
}