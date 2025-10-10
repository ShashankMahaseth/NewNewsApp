package com.example.newnewsapp.presenttion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newnewsapp.navigation.Routes
import com.example.newnewsapp.presenttion.components.ListCountry
import com.example.newnewsapp.viewModel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryScreen(navController: NavController,viewModel: NewsViewModel){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Select Country",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color.White
                    )

                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue),
                modifier = Modifier.shadow(14.dp)
            )
        }
    ){innerPadding->
        Column (modifier = Modifier.fillMaxSize().padding(innerPadding)){
            LazyColumn() {
                items(ListCountry.countries){country->

                    Card(modifier = Modifier.fillMaxWidth().padding(8.dp),
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
                        colors = CardDefaults.cardColors(Color.LightGray),
                        onClick = {
                            viewModel.getNewsArticles(country)
                            navController.navigate(Routes.NewsScreen)

                        }
                        ) {
                        Text(
                            text=country,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            modifier = Modifier.padding(8.dp)

                        )
                    }

                }

            }

        }

    }
}