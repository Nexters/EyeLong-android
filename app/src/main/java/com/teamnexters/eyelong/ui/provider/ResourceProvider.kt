package com.teamnexters.eyelong.ui.provider

interface ResourceProvider {
    fun getString(resId: Int): CharSequence
}