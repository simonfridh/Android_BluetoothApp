package com.example.bluetooth.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bluetooth.data.repository.RepositoryImpl
import com.example.bluetooth.data.sensor.LightSensor
import com.example.bluetooth.data.sensor.MeasurableSensor
import com.example.bluetooth.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface IBlueToothVM {

    fun doTest()

}

@HiltViewModel
class BluetoothVM @Inject constructor(
    private val lightSensor: MeasurableSensor,
    private val repository: IRepository
): IBlueToothVM,  ViewModel() {

    var isDark by mutableStateOf(false)

    init{
        lightSensor.startListening()
        lightSensor.setSensorValuesChangedListener { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
    }

    override fun doTest() {

        repository.test()

    }
}

/*
@HiltViewModel
class BluetoothVM @Inject constructor(
    private val repository: IRepository
): IBlueToothVM, ViewModel() {

    override fun doTest() {

        repository.test()

    }
}
*/

data class SensoreState(
    val isDark: Boolean = false
)


//Used for previews
class FakeVM: IBlueToothVM {
    override fun doTest() {}
}