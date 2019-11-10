package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class UserMention(
    @SerializedName("screen_name")
    val screenName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("id_str")
    val idStr: String = "",
    @SerializedName("indices")
    val indices: List<Int> = listOf()
)