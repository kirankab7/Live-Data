package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    // Create a MutableLiveData object to hold the data
    private val _myLiveData = MutableLiveData<String>()

    // Expose an immutable LiveData object to observe the data
    val myLiveData: LiveData<String>
        get() = _myLiveData

    // Function to update the LiveData
    fun updateData(newData: String) {
        _myLiveData.value = newData
    }
}