package com.example.newsapp.utils

import androidx.room.TypeConverter
import com.example.newsapp.domain.models.Source
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun fromJsonToSource(json: String?): Source? {
        return Gson().fromJson(json, Source::class.java)
    }

    @TypeConverter
    fun fromSourceToJson(source: Source?): String? {
        return Gson().toJson(source)
    }
}