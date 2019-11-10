package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("user_id")
    val userId: String = "",
    @SerializedName("screen_name")
    val screenName: String = "",
    @SerializedName("name")
    val name: String = ""
)