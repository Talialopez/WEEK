package com.example.week

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosWeek(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "mi_base_de_datos"
        private const val DATABASE_VERSION = 1

        private const val create_users_table =
            "CREATE TABLE usuarios (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +  // Use INTEGER instead of INT
                    "CORREO TEXT," +
                    "NOMBRE TEXT," +
                    "PASSWORD TEXT);"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(create_users_table)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }
}