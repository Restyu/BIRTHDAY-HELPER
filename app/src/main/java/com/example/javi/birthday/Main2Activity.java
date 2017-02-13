package com.example.javi.birthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText nombreEdit;
    private EditText telefonoEdit;
    private EditText notificacionEdit;
    private EditText fechaEdit;
    private EditText mensajeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DataBaseManager db = new DataBaseManager(this);

        nombreEdit  = (EditText) findViewById(R.id.nombre);
        telefonoEdit = (EditText) findViewById(R.id.telefono);
        notificacionEdit = (EditText) findViewById(R.id.notificacion);
        fechaEdit = (EditText) findViewById(R.id.fecha);
        mensajeEdit = (EditText) findViewById(R.id.mensaje);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String tx = (String) b.get("perfil");

        int id = Integer.parseInt(tx);

        Contacto perfil = db.Consulta(id);

        nombreEdit.setText(perfil.getNombre());
        telefonoEdit.setText(perfil.getTelefono());
        notificacionEdit.setText(perfil.getTipoNotificacion());
        fechaEdit.setText(perfil.getFechaNacimiento());
        mensajeEdit.setText(perfil.getMensage());

    }
}
