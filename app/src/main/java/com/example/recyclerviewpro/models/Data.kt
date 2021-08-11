package com.example.recyclerviewpro.models

import java.io.Serializable

data class Data(
    var photoTitle: String?, var photoDescription: String?, var authorName: String?,
    var photoUrl: String?, var photoLikes: Int, var photoThumbUrl: String?,
    var authorBio: String?, var authorProfilePhoto: String?
) : Serializable {}