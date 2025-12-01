package com.example.bluetooth.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.bluetooth.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface IBlueToothVM {
    fun doTest()
}

@HiltViewModel
class BluetoothVM @Inject constructor(
    private val repository: IRepository
): IBlueToothVM, ViewModel() {

    override fun doTest() {

        repository.test()

    }
}



//Used for previews
class FakeVM: IBlueToothVM {
    override fun doTest() {}
}