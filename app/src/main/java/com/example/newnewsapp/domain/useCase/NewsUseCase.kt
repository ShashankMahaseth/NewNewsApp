package com.example.newnewsapp.domain.useCase

import com.example.newnewsapp.core.utils.Result
import com.example.newnewsapp.data.remote.NewsDto
import com.example.newnewsapp.data.repositoryImplementation.RepositoryImplementation
import com.example.newnewsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: RepositoryImplementation){
    suspend operator fun invoke(country:String) : Result<NewsDto>{
        return repository.getNewsArticles(country)
    }


}