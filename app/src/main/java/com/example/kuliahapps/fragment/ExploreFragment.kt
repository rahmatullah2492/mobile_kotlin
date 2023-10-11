package com.example.kuliahapps.fragment

import android.content.Intent
import android.graphics.Movie
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuliahapps.DetailMovieActivity
import com.example.kuliahapps.Moviev
import com.example.kuliahapps.MovieAdapter
import com.example.kuliahapps.R
import java.util.*
import kotlin.collections.ArrayList

class ExploreFragment : Fragment() {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Moviev>
    private val originalMovieList = ArrayList<Moviev>() // Menyimpan daftar asli
    private lateinit var searchView: SearchView // Ini baru ditambahkan
    private lateinit var image: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var descriptions: Array<String>
    private var lastSearchQuery: String? = null
    private val lastFilteredList = ArrayList<Moviev>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        adapter = MovieAdapter(movieArrayList) {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        searchView = view.findViewById(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
    }

    private fun dataInitialize() {
        movieArrayList = ArrayList()

        image = arrayOf(
            R.drawable.arsenal,
            R.drawable.brentford,
            R.drawable.brighton,
            R.drawable.chelsea,
            R.drawable.crystalpalace,
            R.drawable.everton,
            R.drawable.liverpool,
            R.drawable.manchesterunited,
            R.drawable.manchestercity,
            R.drawable.newcastleunited,
            R.drawable.nottinghamforest,
            R.drawable.stanley
        )

        title = arrayOf(
            getString(R.string.arsenal),
            getString(R.string.brighton),
            getString(R.string.brentford),
            getString(R.string.chelsea),
            getString(R.string.palace),
            getString(R.string.everton),
            getString(R.string.liverpool),
            getString(R.string.united),
            getString(R.string.city),
            getString(R.string.newcastle),
            getString(R.string.forest),
            getString(R.string.stanley)
        )

        descriptions = arrayOf(
            getString(R.string.arsenal),
            getString(R.string.brighton),
            getString(R.string.brentford),
            getString(R.string.chelsea),
            getString(R.string.palace),
            getString(R.string.everton),
            getString(R.string.liverpool),
            getString(R.string.united),
            getString(R.string.city),
            getString(R.string.newcastle),
            getString(R.string.forest),
            getString(R.string.stanley)
        )

        for (i in image.indices) {
            val movie = Moviev(image[i], title[i], descriptions[i])
            movieArrayList.add(movie)
        }

        // Simpan daftar asli sebelum filter , buat penampung dulu
        originalMovieList.addAll(movieArrayList)
    }

    private fun filter(query: String?) {
        val filteredList = ArrayList<Moviev>()

        if (!query.isNullOrEmpty()) {
            val searchText = query.toLowerCase(Locale.getDefault())
            for (item in originalMovieList) {
                if (item.titleMovie.toLowerCase(Locale.getDefault()).contains(searchText) &&
                        !filteredList.contains(item)) {
                    filteredList.add(item)
                }
            }
        } else {
            filteredList.addAll(originalMovieList)
        }
        adapter.setData(filteredList)
    }
}





