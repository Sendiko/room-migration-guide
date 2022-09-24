package com.sendiko.roomdatabasemigrationexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.sendiko.roomdatabasemigrationexample.R
import com.sendiko.roomdatabasemigrationexample.model.KpopArtists
import com.sendiko.roomdatabasemigrationexample.repository.ViewModelFactory

private const val TAG = "MainFragment"
class MainFragment : Fragment() {

    private val viewModel : MainViewModel by lazy {
        getViewModel(requireNotNull(this.activity))
    }

    private fun getViewModel(activity: FragmentActivity) : MainViewModel {
        return ViewModelProvider(this, ViewModelFactory.getInstance(activity.application))[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.deleteAll()

        viewModel.addArtists(
            KpopArtists(
            0,
            "Jisoo Kim",
            "BLACKPINK",
            "YG"
        ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Jennie Kim",
                "BLACKPINK",
                "YG"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Roseanne Park",
                "BLACKPINK",
                "YG"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Lalisa Manoban",
                "BLACKPINK",
                "YG"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Choi Jisu",
                "ITZY",
                "JYP"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Hwang Yeji",
                "ITZY",
                "JYP"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Ryujin Shin",
                "ITZY",
                "JYP"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Chaeryeong Lee",
                "ITZY",
                "JYP"
            ))

        viewModel.addArtists(
            KpopArtists(
                0,
                "Yuna Shin",
                "ITZY",
                "JYP"
            ))

        viewModel.artistList.observe(viewLifecycleOwner){
            Log.i(TAG, "Kpop artist list: $it")
        }

    }

}