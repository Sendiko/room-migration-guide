package com.sendiko.roomdatabasemigrationexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kpop_artists")
data class KpopArtists(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "name")
    val name : String?= null,

    @ColumnInfo(name = "age", defaultValue = "0")
    val age : String?= null,

    @ColumnInfo(name = "group")
    val group : String?= null,

    @ColumnInfo(name = "agency")
    val agency : String?= null

)
