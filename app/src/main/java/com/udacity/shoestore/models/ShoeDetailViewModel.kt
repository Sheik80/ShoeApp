package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel() : ViewModel() {

    // Event which triggers the end of choosing the shoe
    private val _eventShoeAddFinish = MutableLiveData<Boolean>()
    val eventShoeAddFinish: LiveData<Boolean>
        get() = _eventShoeAddFinish

    private var _shoeAdd: MutableLiveData<Boolean> = MutableLiveData()
    val shoeAdd: LiveData<Boolean>
        get() = _shoeAdd

    private var _shoeListDetails = MutableLiveData<MutableList<Shoe>>()
    val shoeListDetails: MutableLiveData<MutableList<Shoe>>
        get() = _shoeListDetails

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

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
        _shoeName.value = "UdacityShoe"
        _shoeCompany.value = "Udacity"
        _shoeSize.value = 11.0
        _shoeDetail.value = "UdacityDetail"//removeAllViews();
        _shoeAdd.value = true
        _eventShoeAddFinish.value =
            true // надо вызывать по буоолеан если тру то директи включать переход на другой фрагмент
    }

    fun onSaveDetail() {

        val shoe = _shoeSize.value?.let {
            Shoe(
                _shoeName.value.toString(),
                it.toDouble(),
                _shoeCompany.value.toString(),
                _shoeDetail.value.toString()
            )
        }
        shoe?.let { _shoeListDetails.value?.add(it) }
    }

    fun onChooseComplete() {
        _eventShoeAddFinish.value = false
    }

}