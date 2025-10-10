package com.example.newnewsapp.domain.repository

import com.example.newnewsapp.core.utils.Result
import com.example.newnewsapp.data.remote.NewsDto

interface NewsRepository {
    suspend fun getNewsArticles(country: String): Result<NewsDto>
}