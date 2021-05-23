package com.merveylcu.rickandmorty.util.extensions

import com.merveylcu.rickandmorty.util.RegexUtils
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.isValidEmail(): Boolean {
    val expression = RegexUtils.email.pattern
    val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher: Matcher = pattern.matcher(this)
    return matcher.matches()
}

fun String.formatDate(parserFormat: String, formatterFormat: String): String {
    if (this.isBlank().not()) {
        val parser = SimpleDateFormat(parserFormat, Locale.getDefault())
        val formatter = SimpleDateFormat(formatterFormat, Locale.getDefault())
        val date = parser.parse(this)
        date?.let {
            return formatter.format(date)
        }
    }
    return ""
}