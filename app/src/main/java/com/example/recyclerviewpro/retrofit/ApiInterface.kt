package com.example.recyclerviewpro.retrofit

import com.example.recyclerviewpro.models.Constant
import com.example.recyclerviewpro.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(Constant.UPLOAD_PICTURE_PATH_API)
    fun getPhotosList(
        @Query("query") searchedItem: String,
        @Query("orientation") orientation: String,
        @Query("client_id") accessKey: String
    ): Call<PhotoList>

}