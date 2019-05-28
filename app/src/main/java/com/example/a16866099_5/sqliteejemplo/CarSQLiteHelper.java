package com.example.a16866099_5.sqliteejemplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla Cars
    String sqlCreate = "CREATE TABLE Cars (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, color TEXT)";

    public CarSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.sqlCreate = sqlCreate;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //se elimina la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Cars");

        //se crea la nueva version de la tabla
        db.execSQL(sqlCreate);
    }
}
