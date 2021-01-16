package com.teamnexters.eyelong.wrapper.provider

import java.io.*

interface DataStorageProvider {
    fun getStringData(key: String): String?
    fun setStringData(key: String, data: String)
    fun getSerializableData(key: String): Serializable?
    fun setSerializableData(key: String, data: Serializable)
    fun getIntData(key: String): Int
    fun setIntData(key: String, data: Int)
    fun getDoubleData(key: String): Double
    fun setDoubleData(key: String, data: Double)
}
