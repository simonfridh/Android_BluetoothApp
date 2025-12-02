package com.example.bluetooth.di

import android.app.Application
import com.example.bluetooth.data.sensor.LightSensor
import com.example.bluetooth.data.sensor.MeasurableSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    //Sensor
    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasurableSensor{
        return LightSensor(app)
    }


}