package com.example.newnewsapp.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    val nextPage: String,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)