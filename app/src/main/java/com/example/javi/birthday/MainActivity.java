package com.example.javi.birthday;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Button button;
    private TextView textView;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se crea la base de datos
        DataBaseManager manager = new DataBaseManager(this);

        lista = (ListView) findViewById(R.id.ListView);

        contactos();
    }



    public void contactos(){


        DataBaseManager manager = new DataBaseManager(this);

        String[] projeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER };

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
            Contacto contacto = new Contacto(0, 0, "", "", "Solo notificacion", "", "");

            manager.insertar(c.getInt(0),c.getString(1),c.getString(2));
            l.add(contacto);

        }
        lista.setAdapter(new ContactoAdapter(this, l));
        c.close();

    }


    private void rellenaLista() {

        List<Contacto> l = new ArrayList<Contacto>();
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "SMS", "", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 1, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));
        l.add(new Contacto(R.mipmap.h, 2, "pepe", "999999999", "Solo notificacion", "02/05/1993", ""));


        lista.setAdapter(new ContactoAdapter(this, l));
    }

}