package com.example.newnewsapp.data.remote

import kotlinx.serialization.Serializable


@Serializable
data class Result(
    val title: String,                 // usually required
    val description: String? = null,   // can be null
    val content: String? = null,       // can be null
    val link: String? = null,          // can be null
    val pubDate: String? = null,       // can be null
    val image_url: String? = null,     // can be null
    val video_url: String? = null,     // can be null
    val source_id: String? = null ,
)