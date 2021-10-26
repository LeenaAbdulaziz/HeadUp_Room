package com.example.headup_room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Celebrity::class],version = 1,exportSchema = false)

abstract class CelebertyDatabase: RoomDatabase() {

        companion object{
            var instant: CelebertyDatabase?=null
            fun getinstant(context: Context): CelebertyDatabase {
                if(instant !=null)
                {
                    return instant as CelebertyDatabase
                }
                instant = Room.databaseBuilder(context, CelebertyDatabase::class.java,"name").run{
                    allowMainThreadQueries() }.build()
                return instant as CelebertyDatabase
            }
        }
        abstract fun celebDao(): CelebDao;
    }
