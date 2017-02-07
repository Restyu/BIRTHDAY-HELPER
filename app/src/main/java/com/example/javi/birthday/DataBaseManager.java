package com.example.javi.birthday;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        campos.put(PHOTO, c.getImagen());


        db.insert(TABLE_NAME,null, campos);
    }

}
