package com.example.lesson33.data.remote.models

import com.example.lesson33.common.base.IBaseDiffModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Episodes(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("episodes")
    @Expose
    val episodes: String? = null,

    @SerializedName("url")
    @Expose
    private var url: String? = null

) : IBaseDiffModel
