package com.example.bluetooth.data.repository

import android.util.Log
import com.example.bluetooth.domain.repository.IRepository

class RepositoryImpl(

): IRepository {

    override fun test() {
        Log.d("BluetoothApp", "HELLO WORLD")
    }

}