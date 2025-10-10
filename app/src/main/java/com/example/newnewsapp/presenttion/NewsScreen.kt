package com.example.newnewsapp.presenttion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.newnewsapp.core.utils.Result
import com.example.newnewsapp.viewModel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(viewModel: NewsViewModel) {

    val newsState by viewModel.newsState.collectAsState()



    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "News APP",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ) },
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            when (newsState) {
                is Result.Idle -> {
                    Text("Select a country to load news")
                }
                is Result.Loading -> {
                    CircularProgressIndicator()
                }
                is Result.Failure -> {
                    Text("Error: ${(newsState as Result.Failure).message}")
                }
                is Result.Success -> {
                    val newsList = (newsState as Result.Success).data.results

                    LazyColumn(modifier = Modifier.fillMaxSize()) {

                        items(newsList) { article ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        text = article.title,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                    val imageUrl = article.image_url ?: "no Image found"
                                    AsyncImage(
                                        model = imageUrl,
                                        contentDescription = article.title,

                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                    )


                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = article.description?:"no Description available",
                                        fontSize = 16.sp
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
