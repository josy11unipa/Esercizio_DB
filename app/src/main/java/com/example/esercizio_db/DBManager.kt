package com.example.esercizio_db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DBManager(val context: Context) {
    private lateinit var db_helper: DbHelper
    private lateinit var db: SQLiteDatabase

    fun open() : DBManager{
          db_helper = DbHelper(context)
        db = db_helper.writableDatabase
        return this
    }

    fun close(){
        db_helper.close()
    }

    fun insert(name: String, desc:String){
        val value = ContentValues().apply{
            put(DbHelper.SUBJECT,name)
            put(DbHelper.DESC,desc)
        }
        db.insert(DbHelper.TABLE_NAME, null, value)
    }

    fun update(id:Long, name: String, desc: String) : Int{
        val selection = "${DbHelper.ID} = ? "
        val selectionArgs = arrayOf(id.toString())

        val values = ContentValues().apply{
            put(DbHelper.SUBJECT,name)
            put(DbHelper.DESC,desc)
        }
        val n = db.update(DbHelper.TABLE_NAME, values, selection, selectionArgs)
        return n
    }
    fun delete(id: Long){
        val selection = "${DbHelper.ID} = ? "
        val selectionArgs = arrayOf(id.toString())
        db.delete(DbHelper.TABLE_NAME, selection, selectionArgs)
    }

    fun fetchAll(): Cursor{
        val projection = arrayOf(DbHelper.ID, DbHelper.SUBJECT, DbHelper.DESC)
        val cursor = db.query(
            DbHelper.TABLE_NAME, projection, null, null, null, null, null
        )
        cursor?.moveToFirst()
        return cursor
    }
}