package com.tapp.tappnetworking.core.utils

import org.json.JSONObject

internal object JsonUtil {
    /** Very small JSON encoder for maps; keep values simple (String/Number/Boolean/nested Map). */
    fun encode(map: Map<String, Any?>): ByteArray {
        fun putAll(obj: JSONObject, data: Map<String, Any?>) {
            data.forEach { (k, v) ->
                when (v) {
                    null -> obj.put(k, JSONObject.NULL)
                    is Map<*, *> -> {
                        @Suppress("UNCHECKED_CAST")
                        val nested = JSONObject()
                        putAll(nested, v as Map<String, Any?>)
                        obj.put(k, nested)
                    }
                    else -> obj.put(k, v)
                }
            }
        }
        val root = JSONObject()
        putAll(root, map)
        return root.toString().toByteArray(Charsets.UTF_8)
    }
}