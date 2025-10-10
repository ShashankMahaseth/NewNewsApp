package com.example.newnewsapp.data.service

import io.ktor.client.HttpClient
import javax.inject.Inject


class NewsApiService @Inject constructor( val client: HttpClient)