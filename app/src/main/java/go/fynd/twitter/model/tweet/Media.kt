package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id")
    val id: Long? = 0,
    @SerializedName("id_str")
    val idStr: String? = "",
    @SerializedName("indices")
    val indices: List<Int>? = listOf(),
    @SerializedName("media_url")
    val mediaUrl: String? = "",
    @SerializedName("media_url_https")
    val mediaUrlHttps: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("display_url")
    val displayUrl: String? = "",
    @SerializedName("expanded_url")
    val expandedUrl: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("sizes")
    val sizes: Sizes? = Sizes(),
    @SerializedName("features")
    val features: Features? = Features()
)