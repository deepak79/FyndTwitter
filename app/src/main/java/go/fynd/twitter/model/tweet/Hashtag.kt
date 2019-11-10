package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Hashtag(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("indices")
    val indices: List<Int> = listOf()
)