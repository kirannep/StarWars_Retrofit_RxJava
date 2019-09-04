package com.example.starwarapi_retrofit_rxjava.presenter

import com.example.starwarapi_retrofit_rxjava.model.BaseModelPerson

interface ViewInterface {
    fun displayPersonInfo(person: BaseModelPerson)
}