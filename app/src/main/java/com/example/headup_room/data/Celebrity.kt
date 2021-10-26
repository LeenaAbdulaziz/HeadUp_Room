package com.example.headup_room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Celeberty")
data class Celebrity (
        @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id:Int = 0,
        @ColumnInfo(name = "name") var name:String,
        @ColumnInfo(name = "taboo1") var taboo1:String,
        @ColumnInfo(name = "taboo2") var taboo2:String,
        @ColumnInfo(name = "taboo3") var taboo3:String
        )
