package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeDetailViewModel() : ViewModel() {

    // Event which triggers the end of choosing the shoe
    private val _eventShoeAddFinish = MutableLiveData<Boolean>()
    val eventShoeAddFinish: LiveData<Boolean>
        get() = _eventShoeAddFinish

    private var _shoeAdd: MutableLiveData<Boolean> = MutableLiveData()
    val shoeAdd: LiveData<Boolean>
        get() = _shoeAdd

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: MutableLiveData<MutableList<Shoe>>
        get() = _shoeList

    //private var _shoeName = MutableLiveData<String>()
    var shoeName: MutableLiveData<String> = MutableLiveData<String>()


    private val _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String>
        get() = _shoeCompany

    private val _shoeSize = MutableLiveData<Double>()
    val shoeSize: LiveData<Double>
        get() = _shoeSize

    private val _shoeDetail = MutableLiveData<String>()
    val shoeDetail: LiveData<String>
        get() = _shoeDetail

    init {
        shoeList.value = mutableListOf()
        shoeName.value = "UdacityShoe"
        _shoeCompany.value = "Udacity"
        _shoeSize.value = 11.0
        _shoeDetail.value = "UdacityDetail"//removeAllViews();
        _shoeAdd.value = true
        _eventShoeAddFinish.value = true  // надо вызывать по булеан если true то включать переход на другой фрагмент
        shoeName.observeForever(Observer {
        Timber.i(it)

    })
        _shoeCompany.observeForever(Observer {
            Timber.i(it)
        })
    }


    fun onSaveDetail() {

        val shoe = _shoeSize.value?.let {
            Shoe(
                shoeName.value.toString(),
                it.toDouble(),
                _shoeCompany.value.toString(),
                _shoeDetail.value.toString()
            )
        }
        shoe?.let {
            val updatedList = _shoeList.value
            updatedList?.add(it)
            shoeList.value = updatedList?.toMutableList()
        }
        Timber.i("ShoeCreated $shoe")
    }

    fun onChooseComplete() {
        _eventShoeAddFinish.value = false
    }

}