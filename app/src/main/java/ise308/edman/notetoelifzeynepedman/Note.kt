package ise308.edman.notetoelifzeynepedman

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import java.io.*
import java.util.List
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.ArrayList

class Note {
    var title: String? = null
    var description: String? = null
    var idea: Boolean = false
    var todo: Boolean = false
    var important: Boolean = false
    private val JSON_TITLE = "title"
    private val JSON_DESCRIPTION = "description"
    private val JSON_IDEA = "idea"
    private val JSON_TODO = "todo"
    private val JSON_IMPORTANT = "important"

    @Throws(JSONException::class)
    constructor(jo: JSONObject) {
        title = jo.getString(JSON_TITLE)
        description = jo.getString(JSON_DESCRIPTION)
        idea = jo.getBoolean(JSON_IDEA)
        todo = jo.getBoolean(JSON_TODO)
        important = jo.getBoolean(JSON_IMPORTANT)


    }

    @Throws(JSONException::class)
    fun convertToJSON(): JSONObject {
        val jo = JSONObject()
        jo.put(JSON_TITLE, title)
        jo.put(JSON_DESCRIPTION,description)
        jo.put(JSON_IDEA,idea)
        jo.put(JSON_TODO,todo )
        jo.put(JSON_IMPORTANT,important)

        return jo
    }




    }
