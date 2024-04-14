package com.example.newsapp.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.domain.models.Article
import com.example.newsapp.utils.Utils.formatDateString

@Composable
fun ArticleItem(
    article: Article,
    isFav: Boolean,
    onFavoriteClicked: (Article) -> Unit,
    //onArticleClicked: (Article) -> Unit
) {
    // Create local state for the favorite icon
    val isFavorite = remember { mutableStateOf(isFav) }
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageHolder(article.urlToImage)

            Spacer(modifier = Modifier.height(8.dp))

            // Title of the article
            Text(
                text = article.title ?: "",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.description ?: "",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "By ${article.author ?: ""}",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = formatDateString(article.publishedAt ?: ""),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp
                ),
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            FavoriteIcon(
                isFavorite = isFavorite.value,
                onClick = {
                    isFavorite.value = !isFavorite.value
                    onFavoriteClicked(article)
                }
            )
        }
    }
}

@Composable
fun ArticleList(
    articles: List<Article>,
    onFavoriteClicked: (Article) -> Unit,
    //onArticleClicked: (Article) -> Unit,
) {
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        state = listState,
        columns = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxSize()
            .height(700.dp),
    ) {
        items(articles.size, key = { articles[it].description!! }) {
            ArticleItem(
                article = articles[it],
                isFav = articles[it].isFavorite,
                onFavoriteClicked = onFavoriteClicked,
                //onArticleClicked = onArticleClicked
            )
            Divider()
        }
    }
}


@Composable
fun FavoriteIcon(
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    val icon: ImageVector = if (isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Outlined.FavoriteBorder
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentWidth(Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Favorite",
            tint = if (isFavorite) Color.Red else Color.Gray,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onClick()
                }
        )
    }
}



