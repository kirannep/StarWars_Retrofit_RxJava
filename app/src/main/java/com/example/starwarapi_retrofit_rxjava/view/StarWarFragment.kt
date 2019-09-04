package com.example.starwarapi_retrofit_rxjava.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.starwarapi_retrofit_rxjava.R
import com.example.starwarapi_retrofit_rxjava.model.BaseModelPerson
import com.example.starwarapi_retrofit_rxjava.presenter.StarWarPresenter
import com.example.starwarapi_retrofit_rxjava.presenter.ViewInterface
import kotlinx.android.synthetic.main.fragment_star_war.*


class StarWarFragment : Fragment(),ViewInterface {
    override fun displayPersonInfo(person: BaseModelPerson) {
        val adapter : Adapter = Adapter(person)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter
    }

    private lateinit var presenter:StarWarPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_war, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = StarWarPresenter(this)
        presenter.getPersonInfo()
    }
}
