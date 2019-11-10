package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Entities(
    @SerializedName("hashtags")
    val hashtags: List<Hashtag> = listOf(),
    @SerializedName("symbols")
    val symbols: List<Any> = listOf(),
    @SerializedName("user_mentions")
    val userMentions: List<UserMention> = listOf(),
    @SerializedName("urls")
    val urls: List<Url> = listOf()
)