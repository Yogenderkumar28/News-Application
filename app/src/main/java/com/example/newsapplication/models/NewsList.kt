package com.example.newsapplication.models

data class NewsList(
    var totalResults: Int,
    var articles: List<News>
)
