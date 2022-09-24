package com.sendiko.roomdatabasemigrationexample.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sendiko.roomdatabasemigrationexample.model.KpopArtists
import com.sendiko.roomdatabasemigrationexample.repository.Repository
import com.sendiko.roomdatabasemigrationexample.repository.database.ArtistsDatabase
import com.sendiko.roomdatabasemigrationexample.repository.database.DataAccessObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = ArtistsDatabase.getDatabase(application).dao()
    private val repo = Repository(dao)

    val artistList : LiveData<List<KpopArtists>> = repo.artistsList

    fun addArtists(kpopArtists: KpopArtists) = viewModelScope.launch(Dispatchers.IO) { repo.addArtist(kpopArtists) }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) { repo.deleteAll() }

}