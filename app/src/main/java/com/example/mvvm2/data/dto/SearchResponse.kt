package com.example.mvvm2.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("description")
    val description: String,
    @SerialName("display")
    val display: String,
    @SerialName("item")
    val item: Item,
    @SerialName("lastBuildDate")
    val lastBuildDate: String,
    @SerialName("link")
    val link: String,
    @SerialName("start")
    val start: String,
    @SerialName("__text")
    val text: String,
    @SerialName("title")
    val title: String,
    @SerialName("total")
    val total: String
)