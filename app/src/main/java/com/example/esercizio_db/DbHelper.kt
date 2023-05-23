package com.example.esercizio_db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context:Context):SQLiteOpenHelper(context,DaTABASE_NAME,null,DATABASE_VERSION) {

companion object{
    const val DaTABASE_NAME="Materie.db"
    const val DATABASE_VERSION=1
    const val TABLE_NAME="materia"
    const val ID="id"
    const val SUBJECT="subject"
    const val DESC="description"
    private const val DB_CREATE=
        "CREATE TABLE" +
            " ${TABLE_NAME} (${ID} INTEGER PRIMARY KEY,"+
            " ${SUBJECT} TEXT NOT NULL," +
                "${DESC} TEXT );"
    const val SQL_DELETE="DROP TABLE "+
            "IF EXISTS ${TABLE_NAME};"
}

    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL(DB_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE)
        onCreate(db)
    }
}