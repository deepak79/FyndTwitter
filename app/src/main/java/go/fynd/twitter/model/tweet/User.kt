package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("id_str")
    val idStr: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("screen_name")
    val screenName: String? = "",
    @SerializedName("profile_background_image_url")
    val profileBackgroundImageUrl: String? = "",
    @SerializedName("profile_image_url")
    val profileImageUrl: String? = ""
)