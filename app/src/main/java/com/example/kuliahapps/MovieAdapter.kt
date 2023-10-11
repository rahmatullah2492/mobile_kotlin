package com.example.kuliahapps

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter(private val movieList: ArrayList<Moviev>, private val listener: (Moviev) -> Unit) :
        RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(movieList[position], listener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setData(newList: List<Moviev>) {
        movieList.clear()
        movieList.addAll(newList)
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.iv_img)
        private val titleMovie: TextView = itemView.findViewById(R.id.tv_title)
        private val descMovie: TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(movie: Moviev, listener: (Moviev) -> Unit) {
            // Set tampilan sesuai dengan data Moviev
            imageView.setImageResource(movie.imageMovie)
            titleMovie.text = movie.titleMovie
            descMovie.text = movie.descMovie

            // Menanggapi klik pada item RecyclerView
            itemView.setOnClickListener {
                listener(movie)
            }
        }
    }
}