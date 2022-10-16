package com.jc.android.plantdairy.utils

import androidx.room.TypeConverter


object StringListConverter {
    @TypeConverter
    @JvmStatic
    fun toList(strings: String?): List<String>? {
        if (strings != null) {
            val list = mutableListOf<String>()

            // If strings starts with "+" then the result will be a list of at least one item
            // Otherwise, the result will be an empty list
            if (strings.startsWith("+")) {
                val prefixRemovedString = strings.removePrefix("+")
                val array = prefixRemovedString.split(",")

                for (s in array) {
                    list.add(s)
                }

                return list
            } else {
                return list
            }
        } else {
            return null
        }
    }

    @TypeConverter
    @JvmStatic
    fun toString(strings: List<String>?): String? {
        if (strings != null) {
            var result = ""

            // If strings is a list of a single empty string, we differentiate the result from an empty
            // by prefixing the result with "+"
            if (strings.isNotEmpty()) {
                result += "+"
            }

            strings.forEachIndexed { index, element ->
                result += element
                if(index != (strings.size-1)){
                    result += ","
                }
            }

            return result
        } else {
            return null
        }
    }
}