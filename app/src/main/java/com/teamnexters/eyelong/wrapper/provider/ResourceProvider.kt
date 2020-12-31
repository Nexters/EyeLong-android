package com.teamnexters.eyelong.wrapper.provider

interface ResourceProvider {
    fun getString(resId: Int): String
}