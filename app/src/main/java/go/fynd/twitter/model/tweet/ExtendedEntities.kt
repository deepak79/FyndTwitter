package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class ExtendedEntities(
    @SerializedName("media")
    val media: List<Media> = listOf()
)