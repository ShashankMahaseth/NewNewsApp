package com.example.newnewsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newnewsapp.data.remote.NewsDto
import com.example.newnewsapp.core.utils.Result
import com.example.newnewsapp.domain.useCase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel(){

    private val _newsState = MutableStateFlow<Result<NewsDto>>(Result.Idle)
    val newsState =_newsState.asStateFlow()

     fun getNewsArticles(country:String){
         viewModelScope.launch {
            try {
                _newsState.value = Result.Loading
                val result = newsUseCase(country)

              _newsState.value=  result

            }catch (e: Exception){
                _newsState.value = Result.Failure(e.localizedMessage ?: "Unknown error")
            }
         }
         }


     }
