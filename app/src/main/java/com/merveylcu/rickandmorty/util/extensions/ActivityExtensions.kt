package com.merveylcu.rickandmorty.util.extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.longToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.getStr(resId: Int) = resources.getString(resId)