package com.example.javi.birthday;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se crea la base de datos
        DataBaseManager manager = new DataBaseManager(this);

        lista = (ListView) findViewById(R.id.ListView);

        contactos();



        ListView listView = (ListView) findViewById(R.id.ListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                myIntent.putExtra("perfil", texto.getText().toString());
                startActivity(myIntent);
            }
        });
    }

    public void contactos(){


        DataBaseManager manager = new DataBaseManager(this);

        String[] projeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.Data.PHOTO_URI };

        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                projeccion,
                selectionClause,
                null,
                sortOrder);


        List<Contacto> l = new ArrayList<Contacto>();

        while(c.moveToNext()){
            // Contacto contacto = new Contacto(R.mipmap.h, Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2), "Solo notificacion", "", "");
            Contacto contacto = new Contacto(R.mipmap.h, Integer.parseInt(c.getString(0)), c.getString(1),  c.getString(2), "Solo notificacion", "", "");

            manager.insertar(contacto);
            l.add(contacto);

        }
        lista.setAdapter(new ContactoAdapter(this, l));
        c.close();

    }
}