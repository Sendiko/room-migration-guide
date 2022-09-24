package com.sendiko.roomdatabasemigrationexample.repository

import androidx.lifecycle.LiveData
import com.sendiko.roomdatabasemigrationexample.model.KpopArtists
import com.sendiko.roomdatabasemigrationexample.repository.database.DataAccessObject

class Repository(private val dao : DataAccessObject) {

    val artistsList : LiveData<List<KpopArtists>> = dao.artistsList()

    fun addArtist(kpopArtists: KpopArtists) = dao.addArtists(kpopArtists)

    fun deleteAll() = dao.deleteAll()

}