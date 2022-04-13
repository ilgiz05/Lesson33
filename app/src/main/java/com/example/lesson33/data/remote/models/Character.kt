package com.example.lesson33.data.remote.models

import com.example.lesson33.common.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class Character(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String
) : IBaseDiffModel