package com.example.newnewsapp.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Routes {
    @Serializable
    data object CountryScreen : Routes()

    @Serializable
    data object NewsScreen : Routes()

}