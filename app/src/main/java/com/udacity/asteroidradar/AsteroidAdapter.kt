package com.udacity.asteroidradar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.databinding.AsteroidListBinding

class AsteroidAdapter(private var asteroidList: MutableList<Asteroid>) : RecyclerView.Adapter<AsteroidAdapter.AsteroidViewHolder>() {

    inner class AsteroidViewHolder(val binding: AsteroidListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val binding = AsteroidListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AsteroidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        val currentItem = asteroidList[position]
        holder.binding.asteroid = currentItem
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = asteroidList.size

    fun updateData(newList: List<Asteroid>) {
        asteroidList.clear()
        asteroidList.addAll(newList)
        notifyDataSetChanged()
    }
}