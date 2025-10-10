package com.example.newnewsapp.data.repositoryImplementation

import android.util.Log
import android.util.Log.e
import com.example.newnewsapp.core.utils.Result
import com.example.newnewsapp.data.remote.NewsDto
import com.example.newnewsapp.data.service.NewsApiService
import com.example.newnewsapp.domain.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImplementation @Inject constructor(private val apiService: NewsApiService):
    NewsRepository{
    override suspend fun getNewsArticles(country: String): Result<NewsDto> {
        val apikey = "pub_56c60b7b618a4a8ab5f5ffb245b56ee7"
        return try {
            Log.d("RepositoryImpl", "Fetching news for country: $country")

            val newsDto: NewsDto = apiService.client.get("/api/1/latest") {

                parameter("q", country)
                parameter("apikey", apikey)
            }.body() // Ktor deserializes JSON into NewsDto
            Result.Success(newsDto) // Wrap into your sealed Result
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(e.localizedMessage ?: "Unknown error")
        }
    }

}
