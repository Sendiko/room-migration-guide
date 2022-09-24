package com.sendiko.roomdatabasemigrationexample.repository.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.sendiko.roomdatabasemigrationexample.model.KpopArtists

@Database(
    entities = [KpopArtists::class],
    version = 1,
)
abstract class ArtistsDatabase : RoomDatabase() {

    abstract fun dao() : DataAccessObject

    companion object {
        @Volatile
        private var INSTANCE : ArtistsDatabase ?= null

        fun getDatabase(context: Context) : ArtistsDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArtistsDatabase::class.java,
                    "artists_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}