package com.example.javi.birthday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by javi on 28/1/17.
 */

public class DataBaseManager {

    // nombre que va a tener la tabla en la bd
    public static final String TABLE_NAME = "contactos";

    // varables constantes de la tabla contactos
    public static final String ID = "id";
    public static final String NAME = "nombre";
    public static final String PHONE = "telefono";
    public static final String MESSAGE = "mensaje";
    public static final String NOTIFY = "notificacion";
    public static final String DATE = "birthday";
    public static final String PHOTO = "foto";

    // creacion de tabla contacto
    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key,"
            + NAME + " text not null,"
            + PHONE + " integer,"
            + NOTIFY + " text,"
            + MESSAGE + " text,"
            + DATE + " text,"
            + PHOTO + "text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context){

         helper = new DbHelper(context);
         db = helper.getWritableDatabase();
    }

    public void insertar(Contacto c){

        ContentValues campos = new ContentValues();
        campos.put(ID, c.getId());
        campos.put(NAME, c.getNombre());
        campos.put(PHONE, c.getTelefono());
        campos.put(NOTIFY, c.getTipoNotificacion());
        campos.put(MESSAGE, c.getMensage());
        campos.put(DATE, c.getFechaNacimiento());


        db.insert(TABLE_NAME,null, campos);
    }

    public Contacto Consulta(int id){

        Cursor c = db.rawQuery(" SELECT * from contactos where id = "+ id , null);

        Contacto perfil = null;

        try{
            while(c.moveToNext()){
                perfil = new Contacto(R.mipmap.h, c.getInt(0), c.getString(1),  c.getString(2), c.getString(3), c.getString(4), c.getString(5));
            }
        }catch(Exception e){

        }
        return perfil;
    }

   
}
