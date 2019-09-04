package com.example.starwarapi_retrofit_rxjava.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarapi_retrofit_rxjava.R
import com.example.starwarapi_retrofit_rxjava.common.Conversion
import com.example.starwarapi_retrofit_rxjava.model.BaseModelPerson
import kotlinx.android.synthetic.main.cardview.view.*

class Adapter(private val person:BaseModelPerson):RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return person.results.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.name.text = person.results[position].name
        holder.height.text = Conversion(person.results[position].height)+"ft"
        holder.mass.text = person.results[position].mass.toString()
    }
}

class PersonViewHolder(view: View):RecyclerView.ViewHolder(view){
    val name = view.tv_name
    val height = view.tv_height
    val mass = view.tv_mass
}