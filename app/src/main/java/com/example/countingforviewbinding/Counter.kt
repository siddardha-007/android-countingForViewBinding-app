package com.example.countingforviewbinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Counter: BaseObservable(){

    @get:Bindable
    var count: Int = 0
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    var username: String = "Siddu"
        set(value) {
            field = value
            notifyChange()
        }
}