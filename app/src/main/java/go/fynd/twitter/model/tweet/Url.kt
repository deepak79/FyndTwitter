package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("expanded_url")
    val expandedUrl: String? = "",
    @SerializedName("display_url")
    val displayUrl: String? = "",
    @SerializedName("indices")
    val indices: List<Int>? = listOf()
)