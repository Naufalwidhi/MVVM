package com.naufal.mvvm

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "MVVM"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val PREF_NAME = Pair("name", "")
    private val PREF_TOKEN = Pair("token", "")
    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    var token: String
        get() = preferences.getString(PREF_TOKEN.first, PREF_TOKEN.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PREF_TOKEN.first, value)
        }
    var name: String
        get() = preferences.getString(PREF_NAME.first, PREF_NAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PREF_NAME.first, value)
        }
}