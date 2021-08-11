package com.example.recyclerviewpro.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PhotoList {
    @Expose
    @SerializedName("results")
    var results: List<Results>? = null

    @Expose
    @SerializedName("total_pages")
    var totalPages = 0

    @Expose
    @SerializedName("total")
    var total = 0

    class Results {
        @Expose
        @SerializedName("tags")
        var tags: List<Tags>? = null

        @Expose
        @SerializedName("user")
        var user: User? = null

        @Expose
        @SerializedName("current_user_collections")
        var currentUserCollections: List<String>? = null

        @Expose
        @SerializedName("liked_by_user")
        var likedByUser = false

        @Expose
        @SerializedName("likes")
        var likes = 0

        @Expose
        @SerializedName("categories")
        var categories: List<String>? = null

        @Expose
        @SerializedName("links")
        var links: Links? = null

        @Expose
        @SerializedName("urls")
        var urls: Urls? = null

        @Expose
        @SerializedName("alt_description")
        var altDescription: String? = null

        @Expose
        @SerializedName("description")
        var description: String? = null

        @Expose
        @SerializedName("blur_hash")
        var blurHash: String? = null

        @Expose
        @SerializedName("color")
        var color: String? = null

        @Expose
        @SerializedName("height")
        var height = 0

        @Expose
        @SerializedName("width")
        var width = 0

        @Expose
        @SerializedName("updated_at")
        var updatedAt: String? = null

        @Expose
        @SerializedName("created_at")
        var createdAt: String? = null

        @Expose
        @SerializedName("id")
        var id: String? = null
    }

    class Tags {
        @Expose
        @SerializedName("source")
        var source: Source? = null

        @Expose
        @SerializedName("title")
        var title: String? = null

        @Expose
        @SerializedName("type")
        var type: String? = null
    }

    class Source {
        @Expose
        @SerializedName("cover_photo")
        var coverPhoto: CoverPhoto? = null

        @Expose
        @SerializedName("meta_description")
        var metaDescription: String? = null

        @Expose
        @SerializedName("meta_title")
        var metaTitle: String? = null

        @Expose
        @SerializedName("description")
        var description: String? = null

        @Expose
        @SerializedName("subtitle")
        var subtitle: String? = null

        @Expose
        @SerializedName("title")
        var title: String? = null

        @Expose
        @SerializedName("ancestry")
        var ancestry: Ancestry? = null
    }

    class CoverPhoto {
        @Expose
        @SerializedName("user")
        var user: User? = null

        @Expose
        @SerializedName("current_user_collections")
        var currentUserCollections: List<String>? = null

        @Expose
        @SerializedName("liked_by_user")
        var likedByUser = false

        @Expose
        @SerializedName("likes")
        var likes = 0

        @Expose
        @SerializedName("categories")
        var categories: List<String>? = null

        @Expose
        @SerializedName("links")
        var links: Links? = null

        @Expose
        @SerializedName("urls")
        var urls: Urls? = null

        @Expose
        @SerializedName("alt_description")
        var altDescription: String? = null

        @Expose
        @SerializedName("description")
        var description: String? = null

        @Expose
        @SerializedName("blur_hash")
        var blurHash: String? = null

        @Expose
        @SerializedName("color")
        var color: String? = null

        @Expose
        @SerializedName("height")
        var height = 0

        @Expose
        @SerializedName("width")
        var width = 0

        @Expose
        @SerializedName("promoted_at")
        var promotedAt: String? = null

        @Expose
        @SerializedName("updated_at")
        var updatedAt: String? = null

        @Expose
        @SerializedName("created_at")
        var createdAt: String? = null

        @Expose
        @SerializedName("id")
        var id: String? = null
    }

    class ProfileImage {
        @Expose
        @SerializedName("large")
        var large: String? = null

        @Expose
        @SerializedName("medium")
        var medium: String? = null

        @Expose
        @SerializedName("small")
        var small: String? = null
    }

    class Urls {
        @Expose
        @SerializedName("thumb")
        var thumb: String? = null

        @Expose
        @SerializedName("small")
        var small: String? = null

        @Expose
        @SerializedName("regular")
        var regular: String? = null

        @Expose
        @SerializedName("full")
        var full: String? = null

        @Expose
        @SerializedName("raw")
        var raw: String? = null
    }

    class Ancestry {
        @Expose
        @SerializedName("subcategory")
        var subcategory: Subcategory? = null

        @Expose
        @SerializedName("category")
        var category: Category? = null

        @Expose
        @SerializedName("type")
        var type: Type? = null
    }

    class Subcategory {
        @Expose
        @SerializedName("pretty_slug")
        var prettySlug: String? = null

        @Expose
        @SerializedName("slug")
        var slug: String? = null
    }

    class Category {
        @Expose
        @SerializedName("pretty_slug")
        var prettySlug: String? = null

        @Expose
        @SerializedName("slug")
        var slug: String? = null
    }

    class Type {
        @Expose
        @SerializedName("pretty_slug")
        var prettySlug: String? = null

        @Expose
        @SerializedName("slug")
        var slug: String? = null
    }

    class User {
        @Expose
        @SerializedName("for_hire")
        var forHire = false

        @Expose
        @SerializedName("accepted_tos")
        var acceptedTos = false

        @Expose
        @SerializedName("total_photos")
        var totalPhotos = 0

        @Expose
        @SerializedName("total_likes")
        var totalLikes = 0

        @Expose
        @SerializedName("total_collections")
        var totalCollections = 0

        @Expose
        @SerializedName("profile_image")
        var profileImage: ProfileImage? = null

        @Expose
        @SerializedName("links")
        var userLinks: Userlinks? = null
            private set

        @Expose
        @SerializedName("last_name")
        var lastName: String? = null

        @Expose
        @SerializedName("first_name")
        var firstName: String? = null

        @Expose
        @SerializedName("name")
        var name: String? = null

        @Expose
        @SerializedName("username")
        var username: String? = null

        @Expose
        @SerializedName("updated_at")
        var updatedAt: String? = null

        @Expose
        @SerializedName("bio")
        var bio: String? = null

        @Expose
        @SerializedName("id")
        var id: String? = null
    }

    class Userlinks {
        @Expose
        @SerializedName("followers")
        var followers: String? = null

        @Expose
        @SerializedName("following")
        var following: String? = null

        @Expose
        @SerializedName("portfolio")
        var portfolio: String? = null

        @Expose
        @SerializedName("likes")
        var likes: String? = null

        @Expose
        @SerializedName("photos")
        var photos: String? = null

        @Expose
        @SerializedName("html")
        var html: String? = null

        @Expose
        @SerializedName("self")
        var self: String? = null
    }

    class Links {
        @Expose
        @SerializedName("download_location")
        var downloadLocation: String? = null

        @Expose
        @SerializedName("download")
        var download: String? = null

        @Expose
        @SerializedName("html")
        var html: String? = null

        @Expose
        @SerializedName("self")
        var self: String? = null
    }
}