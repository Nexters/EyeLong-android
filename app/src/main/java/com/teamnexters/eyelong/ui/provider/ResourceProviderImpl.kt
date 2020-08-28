package com.teamnexters.eyelong.ui.provider

import android.content.Context

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun getString(resId: Int) = context.getString(resId)
}