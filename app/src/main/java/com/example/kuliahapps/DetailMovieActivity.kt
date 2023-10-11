package com.example.kuliahapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.kuliahapps.fragment.ExploreFragment

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Movie = intent.getParcelableExtra<Moviev>(ExploreFragment.INTENT_PARCELABLE)

        val imageMovie = findViewById<ImageView>(R.id.img_item_photo)
        val titleMovie = findViewById<TextView>(R.id.tv_item_name)
        val descMovie = findViewById<TextView>(R.id.tv_item_description)

        imageMovie.setImageResource(Movie?.imageMovie!!)
        titleMovie.text = Movie.titleMovie
        descMovie.text = Movie.descMovie

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}