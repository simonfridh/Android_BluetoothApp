package com.example.bluetooth.data.sensor

abstract class MeasurableSensor(
    protected val sensorType: Int
) {
    protected var sensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val sensorAvailable: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    fun setSensorValuesChangedListener(listener: (List<Float>) -> Unit){
        sensorValuesChanged = listener
    }
}