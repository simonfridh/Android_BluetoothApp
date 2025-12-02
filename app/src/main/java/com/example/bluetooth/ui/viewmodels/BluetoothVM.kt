package com.example.bluetooth.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bluetooth.data.sensor.MeasurableSensor
import com.example.bluetooth.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface IBlueToothVM {
    val sensorState: StateFlow<SensorState>
    fun doTest()

}

@HiltViewModel
class BluetoothVM @Inject constructor(
    private val lightSensor: MeasurableSensor,
    private val repository: IRepository
): IBlueToothVM,  ViewModel() {
    private val _sensorState = MutableStateFlow(SensorState())
    override val sensorState: StateFlow<SensorState>
        get() = _sensorState

    var isDark by mutableStateOf(false)

    init{
        lightSensor.startListening()
        lightSensor.setSensorValuesChangedListener { values ->
            val lux = values[0]
            _sensorState.value = _sensorState.value.copy(isDark = lux < 60f)
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

data class SensorState(
    val isDark: Boolean = false
)


//Used for previews
class FakeVM: IBlueToothVM {
    override val sensorState: StateFlow<SensorState>
        get() = MutableStateFlow(SensorState())

    override fun doTest() {}
}