package com.example.starwarapi_retrofit_rxjava.presenter

import android.util.Log
import com.example.starwarapi_retrofit_rxjava.model.BaseModelPerson
import com.example.starwarapi_retrofit_rxjava.network.GetPersonRequest
import com.example.starwarapi_retrofit_rxjava.network.RetrofitInstance
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class StarWarPresenter(_view:ViewInterface):PresenterInterface {


    var view:ViewInterface = _view
    var personmodel:BaseModelPerson? = null
    val personObserver = PersonObserver()
    var compositeDisposable = CompositeDisposable()

    override fun getPersonInfo() {
        val personRequest = RetrofitInstance().retrofitInstance.create(GetPersonRequest::class.java)
        val call: Observable<BaseModelPerson> = personRequest.getpersonRequest()
            call
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(personObserver)
    }

    private fun PersonObserver(): Observer<BaseModelPerson> {
        return object:Observer<BaseModelPerson>{
            override fun onComplete() {
                Log.d("emitted","all items emitted")
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }

            override fun onNext(t: BaseModelPerson) {
                Log.d("person1",t.results[0].name)
                view.displayPersonInfo(t)
            }

            override fun onError(e: Throwable) {
                view.displayErrorInfo()
            }
        }
    }

}