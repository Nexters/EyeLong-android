package com.teamnexters.eyelong.wrapper.provider

import android.content.Context
import java.io.Serializable

class PreferencesProviderImpl(context: Context) : PreferencesProvider {
    private val sharedPref = context.getSharedPreferences("preferences", Context.MODE_PRIVATE)

    override fun getStringData(key: String): String? {
        return sharedPref.getString(key, "")
    }

    override fun setStringData(key: String, data: String) {
        with(sharedPref.edit()) {
            putString(key, data)
            commit()
        }
    }

    override fun getSerializableData(key: String): Serializable? = null
    override fun setSerializableData(key: String, data: Serializable) {}

    override fun getIntData(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    override fun setIntData(key: String, data: Int) {
        with(sharedPref.edit()) {
            putInt(key, data)
            commit()
        }
    }

    override fun getDoubleData(key: String): Double {
        return sharedPref.getFloat(key, 0f).toDouble()
    }

    override fun setDoubleData(key: String, data: Double) {
        with(sharedPref.edit()) {
            putFloat(key, data.toFloat())
            commit()
        }
    }
}
