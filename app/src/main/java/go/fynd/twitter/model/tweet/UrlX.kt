package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class UrlX(
    @SerializedName("urls")
    val urls: List<UrlXX>? = listOf()
)