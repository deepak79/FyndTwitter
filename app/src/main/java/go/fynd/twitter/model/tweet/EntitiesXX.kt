package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class EntitiesXX(
    @SerializedName("hashtags")
    val hashtags: List<Any>? = listOf(),
    @SerializedName("symbols")
    val symbols: List<Any>? = listOf(),
    @SerializedName("user_mentions")
    val userMentions: List<Any>? = listOf(),
    @SerializedName("urls")
    val urls: List<UrlXXX>? = listOf()
)