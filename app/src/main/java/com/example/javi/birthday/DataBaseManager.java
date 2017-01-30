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

    // creacion de tabla contacto
    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key,"
            + NAME + " text not null,"
            + PHONE + " integer,"
            + NOTIFY + " text,"
            + MESSAGE + " text,"
            + DATE + " text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context){

         helper = new DbHelper(context);
         db = helper.getWritableDatabase();
    }

    public void insertar(int id , String nombre , String numero){

        ContentValues campos = new ContentValues();
        campos.put(ID, id);
        campos.put(NAME, nombre);
        campos.put(PHONE, numero);

        db.insert(TABLE_NAME,null, campos);
    }

}
