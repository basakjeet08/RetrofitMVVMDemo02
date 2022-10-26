package com.example.retrofitmvvmdemo02.model

data class ArticleData(
    val source : SourceData? ,
    val author : String? ,
    val title : String? ,
    val description : String? ,
    val urlToImage : String? ,
    val publishedAt : String? ,
    val content : String?
)
