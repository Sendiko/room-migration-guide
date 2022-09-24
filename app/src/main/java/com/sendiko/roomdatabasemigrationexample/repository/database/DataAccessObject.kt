package com.sendiko.roomdatabasemigrationexample.repository.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sendiko.roomdatabasemigrationexample.model.KpopArtists

@Dao
interface DataAccessObject {

    @Insert
    fun addArtists(kpopArtists: KpopArtists)

    @Query("select * from kpop_artists order by id asc")
    fun artistsList() : LiveData<List<KpopArtists>>

    @Query("delete from kpop_artists")
    fun deleteAll()

}