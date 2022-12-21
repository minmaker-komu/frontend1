package com.egg.everylogg.activity

import com.google.gson.annotations.SerializedName

class ExampleResponse {
    data class User(
        @SerializedName("name")
        val name:String,

        @SerializedName("password")
        val password: String

    )


}