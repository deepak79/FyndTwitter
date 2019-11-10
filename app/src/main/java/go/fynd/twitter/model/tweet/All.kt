package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("tags")
    val tags: List<Tag> = listOf()
)