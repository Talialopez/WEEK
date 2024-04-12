package com.example.appweek

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "WEEKBBDD"
        private const val DATABASE_VERSION = 2

        private const val create_users_table =
            "CREATE TABLE usuarios (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "CORREO TEXT," +
                    "NOMBRE TEXT," +
                    "PASSWORD TEXT," +
                    "PRIMER_INICIO INTEGER DEFAULT 1);"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(create_users_table)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }
}
